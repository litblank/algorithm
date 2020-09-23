package com.litblank.array.simple;

import java.util.Arrays;

/**
 *
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 *
 *     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *     要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Array_rotate_189
 * @Author: chenyadong
 * @Date: 2020/9/7 11:42
 */
public class Array_rotate_189 {


    /**
     * 双重循环
     * @description
     * @author chenyadong
     * @date 2020/9/7 15:11
     */
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        for (int i = 0; i < k; i++) {
            int far=nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                int s=nums[j];
                nums[j]=far;
                far=s;
            }
        }
    }

    /**
     * 其他方式：
     *
     * 1、三次旋转，
     *
     * 2、环状替换，问题形成闭环
     *
     */



    public static void main(String[] args) {
        int[] nums={-1,-100,3,99};
//        Array_rotate_189.rotate(nums,5);
        int start=0;
        int end=nums.length-1;
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
