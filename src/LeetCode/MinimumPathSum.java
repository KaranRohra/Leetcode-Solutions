package LeetCode;

public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(new Solution64().minPathSum(
                new int[][]{
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                }
        ));
    }
}
//https://leetcode.com/problems/minimum-path-sum/submissions/
class Solution64 {// 1 ms
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        dp=new int[n][m];
        // for(int i=0;i<n;i++){ optional in this code
        //     Arrays.fill(dp[i],-1);
        // }
        return findPath(grid,n-1,m-1,0,0);
    }
    private int findPath(int[][] grid,int n,int m,int i,int j){
        if(i==n && j==m){
            return dp[i][j]=grid[i][j];
        }
        if(dp[i][j]!=0)
            return dp[i][j];
        int sum1=Integer.MAX_VALUE,sum2=Integer.MAX_VALUE;
        if(i<n){
            sum1=findPath(grid,n,m,i+1,j);
        }
        if(j<m){
            sum2=findPath(grid,n,m,i,j+1);
        }
        return dp[i][j]=Math.min(sum1,sum2)+grid[i][j];
    }
}