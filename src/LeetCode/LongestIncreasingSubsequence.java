package LeetCode;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(
                new Solution300().lengthOfLIS(
                        new int[]{10,9,2,5,3,4}
                )
        );
    }
}
//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution300 {// 600 ms
    int[][] dp;
    public int lengthOfLIS(int[] a) {
        int n=a.length;
        dp=new int[n+1][n+2];
        Arrays.stream(dp).forEach(temp-> Arrays.fill(temp,-1));
        return findLongestIncreasingSubsequence(a,n,-1,0);
    }
    public int findLongestIncreasingSubsequence(int[] a,int n,int prev,int i){
        if(i==n)
            return dp[i][prev+1]=0;
        if(dp[i][prev+1]!=-1)
            return dp[i][prev+1];

        if(prev==-1 || a[prev]<a[i]){
            return dp[i][prev+1]=Math.max(
                    findLongestIncreasingSubsequence(a,n,i,i+1)+1,
                    findLongestIncreasingSubsequence(a,n,prev,i+1)
            );
        }
        else{
            return dp[i][prev+1]=findLongestIncreasingSubsequence(a,n,prev,i+1);
        }
    }
}
