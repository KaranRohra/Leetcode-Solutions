package LeetCode;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{
                2,3,1,1,4
        }));
    }
}
//https://leetcode.com/problems/jump-game/
class Solution55 {// 1788 ms and 6 incorrect submissions
    private Boolean[] dp;
    public boolean canJump(int[] a) {
        dp=new Boolean[a.length+1];
        return tryToJump(a,0,a.length);
    }

    public boolean tryToJump(int[] a,int i,int n){
        if(i>=n)
            return false;
        if(dp[i]!=null)
            return dp[i];
        if(i==n-1)
            return dp[i]=true;
        for(int k=a[i];k>=1;k--){
            if(tryToJump(a,i+k,n))
                return dp[i]=true;
        }
        return dp[i]=false;
    }
}