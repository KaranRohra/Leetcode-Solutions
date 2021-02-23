package LeetCode;

import java.util.*;

public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[]{
                4,2,3
        },1));
    }
}
//https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
class Solution1005 {// 3 ms and 6 incorrect submissions
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int n=A.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(A[i]>=0 && K>0){
                if(K%2!=0) {
                    if(i>0 && A[i-1]<A[i]){
                        sum-=A[i-1];
                        A[i-1]=-A[i-1];
                        sum+=A[i-1];
                    }
                    else{
                        A[i]=-A[i];
                    }
                }
                K=0;
            }
            if(K-->0)
                A[i]=-A[i];
            sum+=A[i];
        }
        return sum;
    }
}