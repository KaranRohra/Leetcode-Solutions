package LeetCode;

import java.util.*;

public class WordSubsets {
    public static void main(String[] args) {
        System.out.println(
                new Solution916().wordSubsets(
                        new String[]{
                                "amazon","apple","facebook","google","leetcode"
                        },
                        new String[]{
                                "lo","eo"
                        }
                )
        );
    }
}
//https://leetcode.com/problems/word-subsets/
class Solution916 {//23 ms
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans=new ArrayList<>();

        int n=B.length;
        int[] cnt=new int[26];

        for(int i=0;i<n;i++){
            int m=B[i].length();
            int[] temp=new int[26];
            for(int j=0;j<m;j++){
                temp[B[i].charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++){
                cnt[j]=Math.max(temp[j],cnt[j]);
            }
        }
        n=A.length;
        outer:
        for(int i=0;i<n;i++){
            int m=A[i].length();
            int[] temp=new int[26];

            for(int j=0;j<m;j++){
                temp[A[i].charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++){
                if(temp[j]<cnt[j])
                    continue outer;
            }
            ans.add(A[i]);
        }
        return ans;
    }
}