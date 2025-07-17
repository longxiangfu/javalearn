package com.tc.jdk.foundation.algorithm.algotithm;

import java.util.Arrays;

/**
 * 寻找数组中心下标
 * 假如 1 7之和 = 7 3 6 5 6，那么中心为7，中心下标为1
 */
public class ArrayCenter {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    /**
     * 返回中心元素下标
     * @param nums
     * @return
     */
    private static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i <nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }

            sum -= nums[i];
        }

        return -1;
    }
}
