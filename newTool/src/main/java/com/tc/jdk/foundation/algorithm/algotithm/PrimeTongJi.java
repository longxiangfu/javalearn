package com.tc.jdk.foundation.algorithm.algotithm;


/**
 * 素数统计: 统计n以内的素数个数，0和1除外
 * 暴力算法：一个数一个数计算。类似迭代法
 */
public class PrimeTongJi {

    /**
     * 暴力算法
     * @param n 统计n以内的素数个数（不包括n）
     * @return 素数个数
     */
    public static int bl(int n){
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }

        return count;
    }

    /**
     * 判断素数
     * @param x 要判断的数
     * @return true 是素数，false 不是素数
     */
    private static boolean isPrime(int x) {
        for (int i = 2; i * i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("素数个数：" + bl(100));
    }
}
