package LeetCode;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        System.out.println(new Solution718().findLength(
                new int[]{1,2,3,2,1},
                new int[]{3,2,1,4,7}
        ));
    }
}
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
class Solution718 {// 52 ms
    private int max;
    private int[][] dp;
    public int findLength(int[] A, int[] B) {
        int n=A.length,m=B.length;
        max=0;
        dp=new int[n+1][m+1];
        // Arrays.stream(dp).forEach(temp-> Arrays.fill(temp,-1)); initialization for recursive approach
        // findLength(A,B,n,m);

        for(int i=1;i<=n;i++){// Iterative
            for(int j=1;j<=m;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);

                }
            }
        }
        return max;
    }
    private int findLength(int[] a,int[] b,int n,int m){// Memoization 312 ms
        if(n==0 || m==0)
            return dp[n][m]=0;
        if(dp[n][m]!=-1)
            return dp[n][m];

        int sub1=findLength(a,b,n-1,m);
        int sub2=findLength(a,b,n,m-1);
        max=Math.max(max,Math.max(sub1,sub2));

        if(a[n-1]==b[m-1]){
            int sub3=findLength(a,b,n-1,m-1)+1;
            max=Math.max(sub3,max);
            return dp[n][m]=sub3;
        }
        return dp[n][m]=0;
    }
}