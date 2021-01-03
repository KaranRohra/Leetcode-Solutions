package LeetCode;

import java.util.Scanner;

public class ArrayNesting {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution565 s = new Solution565();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.arrayNesting(a));
    }
}
class Solution565 {
    public int arrayNesting(int[] a) {
        int n=a.length,max=0;
        boolean []p=new boolean[n];
        for (int value : a) {
            int b = value,l=0;
            while (!p[b]) {
                p[b] = true;
                b = a[b];
                l++;
            }
            if (l > max)
                max = l;
        }
        return max;
    }
}
