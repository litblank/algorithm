package com.litblank.array.simple;

import java.util.Arrays;

/**
 *
 * 非递减数列
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 *
 * 说明：
 *
 *     1 <= n <= 10 ^ 4
 *     - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 *
 *
 *
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Array_Change
 * @Author: chenyadong
 * @Date: 2020/9/3 17:47
 */
public class Array_Change_665 {

    /**
     * 我的答案
     * 问题：
     * 1、不应该倒叙，倒叙找不到最小
     * 2、更改数字的思路正确，但是改成多少的情况少分析，没定位哪个是错误数值
     *
     */
    public static boolean checkPossibility(int[] nums) {
        System.out.println(Arrays.toString(nums));
        boolean exist=false;
        if(nums.length<3){
            return true;
        }
        for (int i = nums.length-2; i>=0 ; i--) {
            int num=nums[i];
            int right=nums[i+1];
            if(i==0&&!exist){
                return true;
            }
            if(num>right){
                if(exist){
                    return false;
                }
                if((i+2)<=(nums.length-1)){
                    if(nums[i]<=nums[i+2]){
                        exist=true;
                        nums[i+1]=num;
                        continue;
                    }else{
                        if(exist){
                            return false;
                        }else{
                            exist=true;
                            nums[i]=right;
                        }
                    }
                }
                exist=true;
            }
        }
        return true;
    }

    /**
     * 正确答案
     */
//    public static boolean checkPossibility(int[] nums) {
//        int count=0,temp=Integer.MIN_VALUE;
//        for(int i=0;i<nums.length-1;i++){
//            //出现不满足非递减的情况
//            if(nums[i]>nums[i+1]){
//                //第二次出现非递减时直接返回false
//                if(count++>0){
//                    return false;
//                }
//                if(nums[i+1]<temp){
//                    nums[i+1]=nums[i];
//                }else{
//                    nums[i]=temp;
//                }
//            }
//            temp=nums[i];
//        }
//        return true;
//    }





    public static void main(String[] args) {
        int[] nums1={5,7,1,8};
        System.out.println(Array_Change_665.checkPossibility(nums1)+"   ture");
        int[] nums2={5,7,9,8};
        System.out.println(Array_Change_665.checkPossibility(nums2)+"   ture");
        int[] nums3={5,7,1,6};
        System.out.println(Array_Change_665.checkPossibility(nums3)+"   false");
        int[] nums4={3,4,2,3};
        System.out.println(Array_Change_665.checkPossibility(nums4)+"   false");
        int[] nums5={4,2,3};
        System.out.println(Array_Change_665.checkPossibility(nums5)+"   ture");
        int[] nums6={-1,4,2,3};
        System.out.println(Array_Change_665.checkPossibility(nums6)+"   ture");
        int[] nums7={1,4,1,2};
        System.out.println(Array_Change_665.checkPossibility(nums7)+"   ture");
        int[] nums8={1,2,4,5,3};
        System.out.println(Array_Change_665.checkPossibility(nums8)+"   ture");

    }

}
