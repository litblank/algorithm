package com.litblank.string.simple;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 *
 *
 *
 * @ProjectName: algorithm
 * @ClassName: String_longestCommonPrefix_14
 * @Author: chenyadong
 * @Date: 2020/9/9 16:25
 */
public class String_longestCommonPrefix_14 {

    
    /**
     * 暴力解法
     *
     * @author chenyadongTire
     * @date 2020/9/9 17:00
     */
    public static String longestCommonPrefix(String[] strs) {
        String prefix="";
        for (int i = 0; i < strs.length; i++) {
            if(i==0){
                prefix= strs[i];
            }else{
                String temp="";
                for (int j = 1; j <= prefix.length(); j++) {
                    if(strs[i].length()>=j && prefix.substring(0,j).equals(strs[i].substring(0,j))){
                        temp=prefix.substring(0,j);
                    }else{
                        prefix=temp;
                        break;
                    }
                }
            }
        }
        return prefix;
    }


    /**
     *
     * 使用Tire树
     *
     * @author chenyadong
     * @date 2020/9/10 11:17
     */
    public  String longestCommonPrefix2(String[] strs) {
        TireNode tire=new TireNode();
        for (int i = 0; i < strs.length; i++) {
            tire.add(strs[i]);
            if("".equals(strs[i])){
                return "";
            }
        }

        Map<Character, TireNode.Tire>  map=tire.root.getNext();
        String prefix="";
        while (map.size()==1 ){
            for (Character key : map.keySet()) {
                TireNode.Tire tire1=map.get(key);
                prefix=prefix+tire1.getWord()+"";
                map=tire1.getNext();
                if(tire1.isWord){
                    return prefix;
                }
            }
        }

        return prefix;
    }

    class TireNode{
        Tire root=null;

        public TireNode() {
            this.root = new Tire();
        }

        public void add(String s){
            char[] chars=s.toCharArray();
            Tire tireFa=root;
            for (int i = 0; i < chars.length; i++) {
                Tire tireSon=tireFa.getNext().get(chars[i]);
                if(tireSon==null){
                    tireSon=new Tire();
                    tireSon.setWord(chars[i]);
                }
                if(i == chars.length-1){
                    tireSon.setWord(true);
                }
                tireFa.getNext().put(chars[i],tireSon);
                tireFa=tireSon;
            }
        }


        private class Tire{
            Character word;
            boolean isWord;
            Map<Character,Tire> next=new HashMap();

            public Character getWord() {
                return word;
            }

            public void setWord(Character word) {
                this.word = word;
            }

            public boolean isWord() {
                return isWord;
            }

            public void setWord(boolean word) {
                isWord = word;
            }

            public Map<Character, Tire> getNext() {
                return next;
            }

            public void setNext(Map<Character, Tire> next) {
                this.next = next;
            }
        }
    }





    public static void main(String[] args) {
        String[] strings={
                "flower",
                "flo",
                "flo1",
        };
//        System.out.println(String_longestCommonPrefix_14.longestCommonPrefix(strings));


        String_longestCommonPrefix_14 obj=new String_longestCommonPrefix_14();
        System.out.println(obj.longestCommonPrefix2(strings));
    }

}
