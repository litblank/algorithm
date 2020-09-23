package com.litblank.array.simple;

/**
 * 区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 说明:
 *
 *     你可以假设数组不可变。
 *     会多次调用 sumRange 方法。
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Array_sumRange_303
 * @Author: chenyadong
 * @Date: 2020/9/8 14:50
 */
public class Array_sumRange_303 {
    int[] nums=null;
    int[] numsSum=null;


    /**
     *
     * 预热缓存
     * 另一种解法：private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
     *
     * @author chenyadong
     * @date 2020/9/9 10:29
     */
    public Array_sumRange_303(int[] nums) {
        this.nums=nums;
        int sum=0;
        numsSum=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            numsSum[i]=sum;
        }
    }

    public int sumRange(int i, int j) {
        return numsSum[j]-((i-1<0)?0:numsSum[i-1]);
    }


    public static void main(String[] args) {
        int[] nums={
            1,2,3,4,5,6
        };
        Array_sumRange_303 obj = new Array_sumRange_303(nums);
        int param_1 = obj.sumRange(0,0);
        System.out.println(param_1);
    }
}
