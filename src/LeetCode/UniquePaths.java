package LeetCode;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(3,7));
    }
}
//https://leetcode.com/problems/unique-paths/
class Solution62 {// 0 ms
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        return findPaths(m,n,1,1);
    }
    private int findPaths(int n,int m,int i,int j){
        if(dp[i][j]!=0)
            return dp[i][j];
        if(i==n && j==m)
            return dp[i][j]=1;
        int count=0;
        if(j<m)
            count += findPaths(n, m, i, j + 1);
        if(i<n)
            count += findPaths(n, m, i + 1, j);
        return dp[i][j]=count;
    }
}