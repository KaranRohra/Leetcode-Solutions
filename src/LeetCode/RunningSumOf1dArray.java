package leetCode;

import java.util.Scanner;

public class RunningSumOf1dArray {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution1480 s = new Solution1480();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        a=s.runningSum(a);
        for(int i:a)
            System.out.print(i+" ");
    }
}
class Solution1480 {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int []a=new int[n];
        a[0]=nums[0];
        for(int i=1;i<n;i++){
            a[i]=a[i-1]+nums[i];
        }
        return a;
    }
}
