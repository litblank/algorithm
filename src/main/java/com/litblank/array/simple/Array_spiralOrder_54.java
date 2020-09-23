package com.litblank.array.simple;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Array_spiralOrder_54
 * @Author: chenyadong
 * @Date: 2020/9/7 15:49
 */
public class Array_spiralOrder_54 {


    /**
     * 采用顺时针遍历，遍历过的增加标志位的思想
     *
     *
     * @author chenyadong
     * @date 2020/9/8 13:02
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> integers=new ArrayList<Integer>();
        int alr=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        if(matrix.length==0){
            return integers;
        }
        do{
            //从左到右
            for (; j < matrix[0].length; j++) {
                if(matrix[i][j]!=alr){
                    integers.add(matrix[i][j]);
                    matrix[i][j]=alr;
                }else{
                    break;
                }
            }
            j--;
            //从上到下
            for (i++ ; i < matrix.length; i++) {
                if(matrix[i][j]!=alr){
                    integers.add(matrix[i][j]);
                    matrix[i][j]=alr;
                }else{
                    break;
                }
            }
            i--;
            //从右到左
            for (j--; j >= 0; j-- ) {
                if(matrix[i][j]!=alr){
                    integers.add(matrix[i][j]);
                    matrix[i][j]=alr;
                }else{
                    break;
                }
            }
            j++;
            //从下到上
            for (i--; i >= 0; i-- ) {
                if(matrix[i][j]!=alr){
                    integers.add(matrix[i][j]);
                    matrix[i][j]=alr;
                }else{
                    break;
                }
            }
            i++;
            j++;
        }while (integers.size()<(matrix.length*matrix[0].length));
        return integers;
    }


    public static void main(String[] args) {
        int[][] matrix={
            {1,2,3,4,5,6,7,8,9,10},
            {11,12,13,14,15,16,17,18,19,20},
            {11,12,13,14,15,16,17,18,19,20},
            {11,12,13,14,15,16,17,18,19,20},

        };
        System.out.println(Array_spiralOrder_54.spiralOrder(matrix).toString());
    }

}
