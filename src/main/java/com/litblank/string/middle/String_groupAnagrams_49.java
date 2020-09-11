package com.litblank.string.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 * @ProjectName: algorithm
 * @ClassName: String_groupAnagrams_49
 * @Author: chenyadong
 * @Date: 2020/9/11 17:25
 */
public class String_groupAnagrams_49 {


    /**
     * 构造hash，先排序后分类
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            List<String> list=null;
            list=map.get(Arrays.toString(chars));
            if(list==null){
                list=new ArrayList<>();
            }
            list.add(strs[i]);
            map.put(Arrays.toString(chars),list);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] str={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(String_groupAnagrams_49.groupAnagrams(str));

    }

}
