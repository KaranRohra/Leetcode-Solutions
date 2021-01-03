package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum2InputArrayIsSorted {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution167 s = new Solution167();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(Arrays.toString(s.twoSum(a, sc.nextInt())));
    }
}
class Solution167{
    public int[] twoSum(int[] a, int t) {
        int n=a.length;
        int []result=new int[2];
        int i=0,j=n-1;
        while(i<=j){
            if(a[i]+a[j]>t)
                j--;
            else if(a[i]+a[j]<t)
                i++;
            else{
                result[0]=i;
                result[1]=j;
                break;
            }
        }
        return result;
    }
}
