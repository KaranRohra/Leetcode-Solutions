package LeetCode;

import java.util.*;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        System.out.println(new Solution873().lenLongestFibSubseq(new int[]{
                1,3,7,11,12,14,18
        }));
    }
}
//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/submissions/
class Solution873 {// 646 ms
    int[][] dp;
    public int lenLongestFibSubseq(int[] a) {
        int n=a.length;
        int max=0;
        dp=new int[n+1][n+1];
        Arrays.stream(dp).forEach(temp-> Arrays.fill(temp,-1));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int temp=lengthOfFibo(a,0,i,j)+2;
                if(temp>max)
                    max=temp;//+2;
            }
        }
        return max<=2?0:max;
    }
    public int lengthOfFibo(int[] a,int i,int first,int second){
        if(dp[first][second]!=-1)
            return dp[first][second];
        if(i==a.length)
            return dp[first][second]=0;
        int k=binarySearch(a,i,a[first]+a[second]);
        if(k!=-1){
            return dp[first][second]=lengthOfFibo(a,k+1,second,k)+1;
        }
        else
            return dp[first][second]=0;
    }
    public int binarySearch(int[] a,int s,int x){
        int l=s,h=a.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(a[mid]==x)
                return mid;
            else if(a[mid]<x)
                l=mid+1;
            else
                h=mid-1;
        }
        return -1;
    }
}