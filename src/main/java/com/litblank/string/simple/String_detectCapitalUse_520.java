package com.litblank.string.simple;

/**
 *
 * 检测大写字母
 *
 *
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 *     全部字母都是大写，比如"USA"。
 *     单词中所有字母都不是大写，比如"leetcode"。
 *     如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 *
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 示例 1:
 *
 * 输入: "USA"
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: "FlaG"
 * 输出: False
 *
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 *
 *
 * @ProjectName: algorithm
 * @ClassName: String_detectCapitalUse_520
 * @Author: chenyadong
 * @Date: 2020/9/9 10:31
 */
public class String_detectCapitalUse_520 {


    /**
     * 另一种解法
     * 判断大写字母的数量
     *
     *
     * @author chenyadong
     * @date 2020/9/9 14:15
     */
    public static boolean detectCapitalUse(String word) {
        byte[] bytes=word.getBytes();
        if(bytes.length<2){
            return true;
        }
        if(bytes[0]<=90){
            int b=bytes[1];
            for (int i = 2; i < bytes.length; i++) {
                if(b<=90 && bytes[i]<=90){
                }else if(b>=97 && bytes[i]>=97){

                }else{
                    return false;
                }
            }
        }else{
            for (int i = 1; i < bytes.length; i++) {
                if(bytes[i]>=97  && bytes[i]<=122){
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(String_detectCapitalUse_520.detectCapitalUse("XawQ"));
    }


}
