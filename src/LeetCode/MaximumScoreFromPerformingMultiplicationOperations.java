package LeetCode;

public class MaximumScoreFromPerformingMultiplicationOperations {
    public static void main(String[] args) {
        System.out.println(new Solution1770().maximumScore(new int[]{1,2,3},new int[]{3,2,1}));
    }
}
//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
class Solution1770 { // 154 ms and 3 incorrect submissions
    private Integer[][] dp;

    public int maximumScore(int[] nums, int[] multi) {
        int n = nums.length, m = multi.length;
        dp = new Integer[m + 1][m + 1];
        return maximumScore(nums, multi, 0, 0, 0, n);
    }

    private int maximumScore(int[] nums, int[] multi, int low, int high, int m, int n) {
        if (m == multi.length) {
            return 0;
        }
        if (dp[low][high] != null) {
            return dp[low][high];
        }

        return dp[low][high] = Math.max(
                maximumScore(nums, multi, low + 1, high, m + 1, n) + nums[low] * multi[m],
                maximumScore(nums, multi, low, high + 1, m + 1, n) + nums[n - high - 1] * multi[m]
        );
    }
}