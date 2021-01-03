package LeetCode;

import java.util.Arrays;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1636().frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }
}
//https://leetcode.com/problems/sort-array-by-increasing-frequency/
class Solution1636 {
    public int[] frequencySort(int[] nums) {
        int n=nums.length;
        int[] posCnt=new int[101];
        int[] negCnt=new int[101];
        //int[] a=new int[n];
        for(int val:nums){
            if(val<0)
                negCnt[-val]++;
            else
                posCnt[val]++;
        }

        for(int i=0;i<n;){
            int min=101,index=0;
            boolean isNegative=false;
            for(int j=100;j>=0;j--){
                if(posCnt[j]<min && posCnt[j]!=0){
                    index=j;
                    min=posCnt[j];
                }
            }
            for(int j=0;j<=100;j++){
                if(negCnt[j]<min && negCnt[j]!=0){
                    index=j;
                    min=negCnt[j];
                    isNegative=true;
                }
            }
            if(isNegative){
                i=fill(nums,-index,min,i);
                negCnt[index]=0;
            }
            else{
                i=fill(nums,index,min,i);
                posCnt[index]=0;
            }
        }
        return nums;
    }
    private int fill(int[] a,int n,int count,int i){
        while(count-->0){
            a[i++]=n;
        }
        return i;
    }
}