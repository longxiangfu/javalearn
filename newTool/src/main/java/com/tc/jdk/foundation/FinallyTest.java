package com.tc.jdk.foundation;

/**
 * finally会在程序最后执行
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            if (true) {
                System.out.println("try");
                return;
            }
        }finally {
            System.out.println("finally");
        }
    }


//    start
//    try
//    finally

}
