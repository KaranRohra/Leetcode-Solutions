package leetCode;

import java.util.Scanner;

public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution80 s = new Solution80();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        n=s.removeDuplicates(a);
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}
class Solution80 {
    public int removeDuplicates(int[] a) {
        int n = a.length,newL=0,x;
        for(int i=0;i<n;i++){
            a[newL++]=a[i];
            x=a[i];
            if(i<n-1 && a[i+1]==a[i]){
                a[newL++]=a[++i];
                while (i<n && a[i]==x)
                    i++;
                i--;
            }
        }
        return newL;
    }
}