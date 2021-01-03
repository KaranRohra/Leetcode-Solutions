package LeetCode;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1652().decrypt(new int[]{5, 7, 1, 4}, 3)));
    }
}
//https://leetcode.com/problems/defuse-the-bomb/
class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        if(k==0)
            return new int[n];
        int[] a=new int[n];
        int start=k<0?n+k:1;
        int end=k<0?n-1:k;

        int sum=0;
        for(int i=start;i<=end;i++){
            sum+=code[i];
        }
        a[0]=sum;
        for(int i=1;i<n;i++){

            sum=sum-code[start%n];
            start++;
            end++;
            sum=sum+code[end%n];

            a[i]=sum;
        }
        return a;
    }
}
/*
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        if(k==0)
            return new int[n];
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            if(k<0)
                a[i]=sum(code,-k,i-1,true);
            else
                a[i]=sum(code,k,i+1,false);
        }
        return a;
    }

    private int sum(int[] a,int k,int start,boolean isNegative){
        int sum=0;
        while(k-->0){
            if(isNegative){
                if(start==-1)
                    start=a.length-1;
                sum+=a[start--];
            }else{
                if(start==a.length)
                    start=0;
                sum+=a[start++];
            }
        }
        return sum;
    }
}
*/