package com.tc.jdk.foundation.algorithm.algotithm;

import java.util.Arrays;

/**
 * 寻找数组中心下标
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
        int sum = Arrays.stream(nums).sum(); // 总和
        int total = 0; // 左边所有元素和
        for (int i = 0; i <nums.length; i++) {
            if (total == sum - total - nums[i]) { // 左边所有元素和等于右边所有元素和
                return i;
            }
            total += nums[i];
        }

        return -1;
    }
}
