package com.litblank.hot;

import com.alibaba.fastjson.JSON;

/**
 *
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @ProjectName: algorithm
 * @ClassName: twoSum_1
 * @Author: chenyadong
 * @Date: 2020/11/3 16:42
 */
public class twoSum_1 {

    /**
     *
     * 暴力解法，O（N^2）
     *
     * 合适采用哈希表，解决难以查找的问题O（1）
     *
     *
     * @author chenyadong
     * @date 2020/11/3 17:10
     */
    public static int[] twoSum(int[] nums, int target) {
        int a=0;
        int b=0;
        boolean far=false;
        for (int i = 0; i < nums.length; i++) {
            int diff=target-nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if(diff==nums[j]){
                        a=i;
                        b=j;
                        far=true;
                        break;
                    }
                }
            if(far){
                break;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4,-5};
        System.out.println(JSON.toJSONString(twoSum_1.twoSum(nums,-8)));
    }

}
