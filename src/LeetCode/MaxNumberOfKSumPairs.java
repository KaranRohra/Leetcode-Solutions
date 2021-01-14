package LeetCode;

import java.util.*;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        System.out.println(new Solution1679().maxOperations(
                new int[]{3,1,3,4,3},6
        ));
    }
}
//https://leetcode.com/problems/max-number-of-k-sum-pairs/
class Solution1679 {// 0 ms
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int countPairs=0;
        int n=nums.length;
        int i=0,j=n-1;
        while(i<j){
            if(nums[i]+nums[j]<k)
                i++;
            else if(nums[i]+nums[j]>k)
                j--;
            else{
                countPairs++;
                i++;
                j--;
            }
        }
        return countPairs;
    }
}