package LeetCode;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new Solution674().findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
}
//https://leetcode.com/problems/longest-continuous-increasing-subsequence/
class Solution674 {// 1 ms
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            int len=1;
            while(i<n-1 && nums[i]<nums[i+1]){
                len++;
                i++;
            }
            if(len>res)
                res=len;
        }
        return res;
    }
}