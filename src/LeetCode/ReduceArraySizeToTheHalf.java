package LeetCode;

import java.util.*;

public class ReduceArraySizeToTheHalf {
    public static void main(String[] args) {
        System.out.println(new Solution1338().minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }
}
//https://leetcode.com/problems/reduce-array-size-to-the-half/submissions/
class Solution1338 {// 22 ms
    public int minSetSize(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;){
            int x=arr[i],count=0;
            while(i<n && arr[i]==x){
                arr[i]=-1;
                i++;
                count++;
            }
            arr[i-1]=count;
        }
        Arrays.sort(arr);
        int newLength=n,res=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]==-1)
                break;
            if(newLength > n/2){
                res++;
                newLength-=arr[i];
            }
            else{
                break;
            }
        }

        return res;
    }
}