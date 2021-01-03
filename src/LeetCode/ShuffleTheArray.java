package leetCode;

import java.util.Scanner;

public class ShuffleTheArray {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Solution1470 s=new Solution1470();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        a=s.shuffle(a,a.length/2);
        for(int i:a)
            System.out.println(i+" ");
    }
}
class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int m=2*n;
        int []a = new int[m];
        for(int i=0,j=0,k=n;j<n;i+=2){
            a[i]=nums[j++];
            a[i+1]=nums[k++];
        }
        return a;
    }
}