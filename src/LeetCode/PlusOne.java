package leetCode;

import java.util.Scanner;

public class PlusOne {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution66 s = new Solution66();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int []b=s.plusOne(a);
        for(int i:b)
            System.out.print(i+" ");
    }
}
class Solution66 {
    public int[] plusOne(int[] d) {
        int n=d.length;
        d[n-1]++;
        for(int i=n-1;i>=1;i--){
            if(d[i]==10){
                d[i]=0;
                d[i-1]++;
            }
        }
        if(d[0]==10){
            int []a = new int[n+1];
            a[0]=1;
            a[1]=0;
            System.arraycopy(d, 1, a, 2, n - 1);
            return a;
        }
        return d;
    }
}
