package LeetCode;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(new Solution1004().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
}
//https://leetcode.com/problems/max-consecutive-ones-iii/
class Solution1004 {// 2 ms
    public int longestOnes(int[] A, int k) {
        int n=A.length,res=0;
        int i=0,j=-1;
        while(j!=n-1){
            if(A[j+1]==0 && k!=0){
                j++;
                k--;
            }else if(A[j+1]==1){
                j++;
            }else{
                if(j-i+1>res){
                    res=j-i+1;
                }
                if(A[i]==0)
                    k++;
                i++;
            }
        }
        if(j-i+1>res){
            res=j-i+1;
        }
        return res;
    }
}