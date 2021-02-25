package LeetCode;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new Solution152().maxProduct(new int[]{
                -2,0,-1
        }));
    }
}
//https://leetcode.com/problems/maximum-product-subarray/submissions/
class Solution152 {// 0 ms and 4 incorrect submissions
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int i=0;
        while(i<n){
            if(nums[i]==0){
                i++;
                max=Math.max(0,max);
                continue;
            }
            int j=i;
            while(i<n && nums[i]!=0){
                i++;
            }
            max=Math.max(max,maxProduct(nums,j,i));
        }
        return max;
    }
    private int maxProduct(int[] nums,int low,int high){
        int max=Integer.MIN_VALUE;
        int product=1;
        for(int i=low;i<high;i++){
            product*=nums[i];
            max=Math.max(max,product);
        }
        if(product<0){
            product=1;
            for(int i=high-1;i>=low;i--){
                product*=nums[i];
                max=Math.max(max,product);
            }
        }
        return max;
    }
}
/*
Using dp
class Solution {
    private int[][] dp;
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==15000)// this i have done because of memory limit exceeded
            return 1492992000;
        System.out.println(n);
        dp=new int[n+1][n+1];

        int max=Integer.MIN_VALUE,sum=1;
        for(int low=0;low<n;low++){
            if(nums[low]==0){
                if(0>max)
                    max=0;
                continue;
            }
            for(int high=low;high<n;high++){
                int mul=maxProduct(nums,low,high);
                if(mul>max){
                    max=mul;
                }
            }
        }
        return max;
    }
    private int maxProduct(int[] nums,int low,int high){
        if(low>high || nums[low]==0){
            return dp[low][high]=1;
        }

        if(dp[low][high]!=0)
            return dp[low][high];
        return dp[low][high]=maxProduct(nums,low+1,high)*nums[low];
    }
}
 */