package LeetCode;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(new Solution63().uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
}
class Solution63 {
    private int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length,m=obstacleGrid[0].length;
        dp=new int[n][m];
        return findPaths(obstacleGrid,n-1,m-1,0,0);
    }
    private int findPaths(int[][] a,int n,int m,int i,int j){
        if(dp[i][j]!=0)
            return dp[i][j];
        if(i==n && j==m && a[i][j]!=1)
            return dp[i][j]=1;
        if(a[i][j]==1)
            return dp[i][j]=0;
        int count=0;
        if(j<m)
            count += findPaths(a, n, m, i, j + 1);
        if(i<n)
            count += findPaths(a, n, m, i + 1, j);
        return dp[i][j]=count;
    }
}