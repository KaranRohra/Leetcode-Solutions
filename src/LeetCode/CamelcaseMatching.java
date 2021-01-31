package LeetCode;

import java.util.*;

public class CamelcaseMatching {
    public static void main(String[] args) {
        System.out.println(new Solution1023().camelMatch(new String[]{
                "FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"
        },"FB"));
    }
}
//https://leetcode.com/problems/camelcase-matching/submissions/
class Solution1023 {// 0 ms
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        char[] patternChar = pattern.toCharArray();
        int patternLength = patternChar.length;

        for (String query : queries) {
            boolean tempRes = true;

            int pointer = 0;
            for (char c : query.toCharArray()) {
                if (pointer < patternLength && c == patternChar[pointer]) {
                    pointer++;
                } else if (c >= 'A' && c <= 'Z') {
                    tempRes = false;
                    break;
                }
            }
            if (pointer == patternLength)
                res.add(tempRes);
            else
                res.add(false);
        }
        return res;
    }
}