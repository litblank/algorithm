package com.litblank.hot;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: lengthOfLongestSubstring_3
 * @Author: chenyadong
 * @Date: 2020/11/17 11:08
 */
public class lengthOfLongestSubstring_3 {


    /**
     * 滑动窗口算法
     *
     * 可优化点：在查找是否存在时，可使用hash存储，而不是string
     *
     *
     * @author chenyadong
     * @date 2020/11/17 15:13
     */
    public static int lengthOfLongestSubstring(String s) {
        //构造窗口
        String window="";
        //最大窗口和左侧下标
        int maxL=0,left=0;
        //滑动窗口
        char[] schar=s.toCharArray();
        for (int i = 0; i < schar.length ; i++) {
            //是否满足窗口
            if(!window.contains(schar[i]+"")){
                window+=schar[i];
                //得出最大值
                maxL=maxL<window.length()?window.length():maxL;
            }else{
                //重新计算左侧下标
                left=window.indexOf(schar[i])+1+left;
                window=s.substring(left,i+1);
            }
        }
        return maxL;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring("abcdefabc"));;
    }

}
