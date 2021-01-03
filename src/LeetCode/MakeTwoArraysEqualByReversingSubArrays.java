package leetCode;

import java.util.*;

public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Solution1460 s = new Solution1460();
        int n=sc.nextInt();
        int []a=new int[n];
        int []b=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        System.out.println(s.canBeEqual(a,b));
    }
}
class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n=target.length;
        int a[]=new int[1001];
        for(int i=0;i<n;i++)
            a[target[i]]++;
        for(int i=0;i<n;i++){
            a[arr[i]]--;
            if(a[arr[i]]<0)
                return false;
        }
        return true;
    }
}