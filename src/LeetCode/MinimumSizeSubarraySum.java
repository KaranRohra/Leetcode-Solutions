package LeetCode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(new Solution209().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
//https://leetcode.com/problems/minimum-size-subarray-sum/
class Solution209 {// 1 ms
    public int minSubArrayLen(int s, int[] nums) {
        int n=nums.length;
        int i=0,j=0,sum,res=0;
        sum=nums[i];
        while(j<n){
            if(sum<s){
                j++;
                if(j<n)
                    sum+=nums[j];
            }
            else {
                if(res==0 || res>j-i+1){
                    res=j-i+1;
                }
                sum-=nums[i];

                i++;
            }
        }
        return res;
    }
}