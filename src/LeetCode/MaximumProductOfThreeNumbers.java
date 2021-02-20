package LeetCode;

import java.util.*;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        System.out.println(new Solution628().maximumProduct(new int[]{-1,-2,-3}));
    }
}
//https://leetcode.com/problems/maximum-product-of-three-numbers/
class Solution628 { // 9 ms and 2 incorrect submission
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,max=Integer.MIN_VALUE;

        max=Math.max(max,nums[n-1]*nums[n-2]*nums[n-3]);
        max=Math.max(max,nums[n-1]*nums[n-2]*nums[0]);
        max=Math.max(max,nums[0]*nums[1]*nums[n-1]);

        return max;
    }
}