package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new Solution49().groupAnagrams(new String[]{
                "eat","tea","tan","ate","nat","bat"
        }));
    }
}
//https://leetcode.com/problems/group-anagrams/submissions/
class Solution49 { // 5 ms and 0 incorrect
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();


        for (String s : strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);

            String key = new String(str);

            List<String> bucket = map.computeIfAbsent(key, k -> new ArrayList<>());
            bucket.add(s);

        }
        for(Map.Entry<String,List<String>> hm:map.entrySet()){
            res.add(hm.getValue());
        }

        return res;
    }
}