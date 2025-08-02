package com.tc.jdk.concurrent;

import org.objenesis.instantiator.sun.UnsafeFactoryInstantiator;
import sun.misc.Unsafe;

import java.util.concurrent.locks.LockSupport;

/**
 * 可见性
 */
public class VisibilityTest {
//1 volatile: 底层jvm用了lock;addl的前缀指令（类似内存屏障功能），
// 该指令执行前会执行：所有写操作回写主存，所有本地内存中其他变量副本清空（准确说是清空副本所在缓存行，占64位）
// private volatile boolean flag = true;
    private boolean flag = true;
//5    private volatile int count = 0;
//7 Integer 构造方法使用了final关键字,底层也是使用了内存屏障
// private Integer count = 0;
    private int count = 0;

    public static void main(String[] args) {
        VisibilityTest visibilityTest = new VisibilityTest();
        new Thread(() ->{
            visibilityTest.load();
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() ->{
            visibilityTest.refresh();
        }).start();

    }

    private void refresh() {
        this.flag = false;
        System.out.println(Thread.currentThread() + "修改了flag为：" + this.flag);
    }

    private void load() {
        System.out.println(Thread.currentThread() + "开始load");
        while (this.flag) {
            this.count++;
            //2 内存屏障。oracle jdk不能用      openjdk可以用 UnsafeFactory.getUnsafe().storeFence();
            // 和volatile一样，jvm底层也使用了lock;addl前缀指令
//            Unsafe.getUnsafe().storeFence();

            //3 cpu切换时间片，上下文切换，线程切换回来后，本地内存中flag已经过期，去主内存中获取flag
//            Thread.yield();

            //4 底层使用了synchronized，最底层也是使用了内存屏障，类似volatile
//            System.out.println(count);

            // 6 最底层也是使用了内存屏障，类似volatile
//            LockSupport.unpark(Thread.currentThread());

            // 8  最底层也是使用了内存屏障，类似volatile
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


//            shortWait(1000000); // 1ms --可以跳出循环
//            shortWait(1000); // 1纳秒 --不能跳出循环

            // 可以跳出循环
//            long start = System.nanoTime();
//            long end = 0;
//            while (start + 1000000 >= end) {
//                end = System.nanoTime();
//            };
            // 不能跳出循环
//            long start = System.nanoTime();
//            long end;
//            do {
//                end = System.nanoTime();
//            }while (start + interval >= end);

            // 加上jvm参数-Xint,该参数表示关掉JIT,即现在是解释执行。这样也可以跳出循环
            // JIT：实现将热点代码（.class）翻译成机器码    解释执行：一边翻译一边执行
        }
        System.out.println(Thread.currentThread() + "跳出循环");
    }

    /**
     * 指定方法执行时间
     * @param interval
     */
    private void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        }while (start + interval >= end);

    }
}
