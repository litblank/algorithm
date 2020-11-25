package com.litblank.hot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *
 * babad
 * 1 3 5
 *  2 4
 *
 * 1
 * 2 3
 * 4
 *
 * @ProjectName: algorithm
 * @ClassName: longestPalindrome_5
 * @Author: chenyadong
 * @Date: 2020/11/23 19:00
 */
public class longestPalindrome_5 {

    /**
     * 此处时暴力解法，动态规划减少了重复子问题的计算。
     * 1、暴力遍历
     * 2、动态规划
     *
     * @author chenyadong
     * @date 2020/11/24 14:42
     */
    public String longestPalindrome(String s) {
        int maxL=0;
        char[]  chars=s.toCharArray();
        String str=chars[0]+"";
        for (int i = 0; i < chars.length; i++) {
            for (int f = i; f < chars.length; f++) {
                if(isRever(chars,i,f)){
                    if((f-i)>maxL){
                        maxL=f-i;
                        str=s.substring(i,f+1);
                    }
                }
            }
        }
        return str;
    }

    public static boolean isRever(char[] chars,int i,int f){
        while (i<f){
            if(chars[i]!=chars[f]){
                return false;
            }
            i++;
            f--;
        }
        return true;
    }



}
