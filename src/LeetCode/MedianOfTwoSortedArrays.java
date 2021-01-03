package leetCode;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution4 s = new Solution4();
        int n = sc.nextInt();
        int m=sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for(int i=0;i<m;i++)
            b[i]=sc.nextInt();
        System.out.println(s.findMedianSortedArrays(a,b));
    }
}
class Solution4 {// 2ms
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n=a.length,m=b.length;
        int[] s=new int[m+n];
        int i=0,j=0,k=0,x;
        while(i!=n && j!=m){
            x=Math.min(a[i],b[j]);
            if(x==a[i])
                i++;
            else
                j++;
            s[k++]=x;
        }
        for(;i<n;i++)
            s[k++]=a[i];
        for(;j<m;j++)
            s[k++]=b[j];
        if(s.length%2==0)
            return (double) (s[k/2]+s[k/2-1])/2;
        return s[k/2];
    }
}