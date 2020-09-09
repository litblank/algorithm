package com.litblank.string.simple;

/**
 *
 * 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 * @ProjectName: algorithm
 * @ClassName: String_isPalindrome_125
 * @Author: chenyadong
 * @Date: 2020/9/9 14:34
 */
public class String_isPalindrome_125 {


    /**
     * 此方法采用双指针算法
     *
     * 还可以采用 栈，reverse
     *
     *
     * @author chenyadong
     * @date 2020/9/9 15:30
     */
    public static boolean isPalindrome(String s) {
        char[] bytes=s.toCharArray();
        boolean far=true;
        int i=0;
        int j=bytes.length-1;
        while (i<=j){
            char left=bytes[i];
            char right=bytes[j];
            while ( !Character.isDigit(left) &&  !Character.isLetter(left)){
                i++;
                if(i>=j){
                    return true;
                }
                left=bytes[i];
            }
            while(!Character.isDigit(right) &&!Character.isLetter(right)){
                j--;
                right=bytes[j];
            }
            if(Character.toLowerCase(left)!=Character.toLowerCase(right)){
                far=false;
                break;
            }
            i++;
            j--;
        }
        return far;
    }


    public static void main(String[] args) {
        System.out.println(String_isPalindrome_125.isPalindrome("ab2a"));
    }



}
