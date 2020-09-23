package com.litblank.array.simple;

/**
 *
 *
 * 661. 图片平滑器
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 *
 * 注意:
 *
 *     给定矩阵中的整数范围为 [0, 255]。
 *     矩阵的长和宽的范围均为 [1, 150]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/image-smoother
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: Array_661
 * @Author: chenyadong
 * @Date: 2020/9/7 10:53
 */
public class Array_imageSmoother_661 {

    public static int[][] imageSmoother(int[][] M) {

        int[][] s=new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int[] num1={i-1,i,i+1};
                int[] num2={j-1,j,j+1};
                int sum=0;
                int cot=0;
                for (int k = 0; k < num1.length; k++) {
                    for (int l = 0; l < num2.length; l++) {
                        if(num1[k]>=0 && num1[k]<M.length){
                            if(num2[l]>=0 && num2[l]<M[i].length){
                                sum+=M[num1[k]][num2[l]];
                                cot++;
                            }
                        }
                    }
                }
                s[i][j]=(int) sum/cot;
                System.out.println(sum+"  "+cot+"  "+s[i][j]);
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int[][] m={
                {2,3,4},
                {5,6,7},
                {8,9,10},
                {11,12,13},
                {14,15,16},
        };
        Array_imageSmoother_661.imageSmoother(m);
    }

}
