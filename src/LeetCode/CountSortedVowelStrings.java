package LeetCode;

import java.util.*;

public class CountSortedVowelStrings {
    public static void main(String[] args) {
        System.out.println(new Solution1641().countVowelStrings(2));
    }
}
//https://leetcode.com/problems/count-sorted-vowel-strings/
class Solution1641 {// 0 ms
    private int[][] dp;
    public int countVowelStrings(int n) {
        dp=new int[n+1][6];
        Arrays.stream(dp).forEach(temp->Arrays.fill(temp,-1));
        return count(n,0);
    }
    private int count(int n,int i){
        if(dp[n][i]!=-1)
            return dp[n][i];
        if(i==5)
            return dp[n][i]=0;
        if(n==0){
            return dp[n][i]=1;
        }
        return dp[n][i]=count(n-1,i) + count(n,i+1);
    }
}