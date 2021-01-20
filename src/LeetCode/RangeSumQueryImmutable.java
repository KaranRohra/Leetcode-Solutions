package LeetCode;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray303 s=new NumArray303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(s.sumRange(0,2));
        System.out.println(s.sumRange(2,5));
        System.out.println(s.sumRange(0,5));
    }
}
//https://leetcode.com/problems/range-sum-query-immutable/submissions/
class NumArray303 {// 7 ms
    private Integer[] dp;
    public NumArray303(int[] nums) {

        int n=nums.length;
        if(n==0)
            return;
        dp=new Integer[n+1];
        dp[0]=nums[0];
        for(int i=1;i<n;i++)
            dp[i]=dp[i-1]+nums[i];
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return dp[j];
        return dp[j]-dp[i-1];

    }
}