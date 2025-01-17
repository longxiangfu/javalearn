package com.tc.jdk.classLoader;

import cn.hutool.core.io.resource.ResourceUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] bytes = this.loadByte(name);
                return defineClass(name, bytes, 0, bytes.length);
            }catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }

        }

        private byte[] loadByte(String name) {
            String replaceName = name.replaceAll("\\.", "/");
            byte[] bytes = ResourceUtil.readBytes(classPath + "/" + replaceName + ".class");
            return bytes;
        }


        /**
         * 重写loadClass，打破双亲委派机制
         * @param name
         * @param resolve
         * @return
         * @throws ClassNotFoundException
         */
        @Override
        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    // 自己定义的类，由自定义类加载器加载，否则交给父加载器加载（双亲委派）
                    if (!name.startsWith("com.tc")) {
                        c = this.getParent().loadClass(name);
                    }else {
                        c = findClass(name);
                    }

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }

    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 实例化MyClassLoader,会先调用父类ClassLoader的构造方法，构造方法中将MyClassLoader的parent属性设置为AppClassLoader
        MyClassLoader myClassLoader = new MyClassLoader("D:\\test");
        // 调用父类的loadClass，双亲委派，如果是由自定义加载器加载的话，会调用到自定义加载器的findClass
        Class<?> aClass = myClassLoader.loadClass("com.tc.jdk.classLoader.User1"); //  D:\test\com\tc\jdk\classLoader目录下放置User1.class
        Object instance = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(instance, null);
        // 双亲委派机制
        // 输出：com.tc.jdk.classLoader.MyClassLoaderTest$MyClassLoader
        System.out.println(aClass.getClassLoader().getClass().getName());

    }
}
