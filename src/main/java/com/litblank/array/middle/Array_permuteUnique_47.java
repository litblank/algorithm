package com.litblank.array.middle;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 *  Depth First Search  深度优化搜索
 *
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Array_permuteUnique_47
 * @Author: chenyadong
 * @Date: 2020/9/18 13:43
 */
public class Array_permuteUnique_47 {


    List<List<Integer>> integer=new ArrayList<List<Integer>>();
    public List<List<Integer>>  permuteUnique(int[] nums) {

        DFS(nums,0);
        return integer;
    }


    /**
     *
     * 针对去重方法
     * 1、set保存
     * 2、每轮判断一下是否已经处理过该数据
     * 3、先排序，后跳过重复的数据
     *
     *
     * depth为树深度，也可以理解为起始遍历的指针
     *
     * @author chenyadong
     * @date 2020/9/23 17:30
     */
    private void DFS(int[] nums,int depth){

        if(nums.length-1==depth){
            integer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return ;
        }

        ArrayList arrayList=new ArrayList();
        for (int i = depth; i < nums.length; i++) {
            if(arrayList.contains(nums[i])){
               continue;
            }
            arrayList.add(nums[i]);
            //当前数与当前层数swap
            swap(nums,i,depth);
            //递归
            DFS(nums,depth+1);
            //再互换回来
            swap(nums,i,depth);
        }
    }

    private void swap(int[] nums,int i,int depth){
        int temp=0;
        temp=nums[i];
        nums[i]=nums[depth];
        nums[depth]=temp;
    }


    public static void main(String[] args) {
        int[] nums={1,1,2,3};
        List s=Arrays.asList(nums);
        Array_permuteUnique_47 array_permuteUnique_47=new Array_permuteUnique_47();
        array_permuteUnique_47.permuteUnique(nums);
        System.out.println(array_permuteUnique_47.integer);
    }


}