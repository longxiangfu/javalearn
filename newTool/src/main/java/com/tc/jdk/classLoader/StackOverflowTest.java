    package com.tc.jdk.classLoader;

    /**
     * StackOverflow
     * -Xss  决定方法调用深度
     */
    public class StackOverflowTest {
        static int count = 0;

        public static void main(String[] args) {
            try {
                redo();
            }catch (Throwable e) {
                // 默认线程栈 count=7436
                // 设置-Xss512K count=12352
                // 设置-Xss1M count=25474
                System.out.println(count);
            }
        }

        private static void redo() {
            count++;
            redo();
        }
    }
