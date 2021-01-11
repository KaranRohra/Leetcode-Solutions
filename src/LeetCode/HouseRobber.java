package LeetCode;

import java.util.*;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new Solution198().rob(
                new int[]{2,1,1,2}
        ));
    }
}
//https://leetcode.com/problems/house-robber/submissions/
class Solution198 {// 1 ms
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return maxMoney(nums,n);
    }
    public int maxMoney(int[] a,int n){
        if(n<=0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=Math.max(
                maxMoney(a,n-1),
                maxMoney(a,n-2)+a[n-1]
        );
    }
}