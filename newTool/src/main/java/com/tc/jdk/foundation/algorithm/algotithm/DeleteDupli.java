package com.tc.jdk.foundation.algorithm.algotithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 删除排序数组中的重复项
 * 1、循环数组，将元素依次放入set中。   这种不符合题目条件，不让使用额外的空间
 * 2、（1）两级循环，外循环遍历数组，内循环从i+1开始遍历数组，如果相同，则外循环当前元素置为null。依次比较外循环其他元素 （2）循环数组，将非null的元素依次放入数组中，返回长度
 *  这种不符合题目条件，不让使用额外的空间
 * 3、双指针算法：（1）初始指针i=0 j=1。i为慢指针，j为快指针 （2）如果nums[i]!=nums[j],则nums[i+1]=nums[j],然后i和j都向后移动一位。
 *  （3）否则，i不变，j向后移动一位，然后再比较nums[i]和nums[j] (4)直到j移动到最后，此时看包括i在内的前面的元素的个数
 */
public class DeleteDupli {
    public static void main(String[] args) {
        Integer[] nums = {0, 1, 2, 2, 2, 3, 2, 4, 4, 6};
//        DeleteDupli.byFor(nums);
        DeleteDupli.bySet(nums);
//        DeleteDupli.doublePointer(nums);

        // 十六进制转十进制
        String hexNumber = "1A"; // 示例十六进制数
        int decimalNumber = Integer.parseInt(hexNumber, 16);
        System.out.println("十六进制 " + hexNumber + " 转换为十进制为: " + decimalNumber);

        System.out.println(Integer.decode(""));

    }

    private static void byFor(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    nums[i] = null;
                }
            }
        }

        List<Integer> collect = Arrays.stream(nums).filter(num -> num != null).collect(Collectors.toList());
        System.out.println(collect.size());
    }

    /**
     * 通过set
     * @param nums
     */
    private static void bySet(Integer[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        System.out.println("新数组长度：" + set.size());
    }

    /**
     * 双指针算法
     * @param nums
     */
    private static int doublePointer(Integer[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        System.out.println("新数组长度：" + (i));
        return i;

    }


    /**
     * 获取一个正整数的所有质数因子
     * @param number 给定的正整数
     */
    private static void getPrimeFactors(int number) {
        if (number <= 1) {
            System.out.println("请输入大于1的正整数");
            return;
        }

        System.out.print(number + "的质数因子有：");
        // 从最小的质数开始尝试分解
        for (int i = 2; i <= number; i++) {
            // 当能整除时，继续除以该因子直到不能整除为止
            while (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }
        System.out.println();
    }

}
