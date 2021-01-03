package LeetCode;

import java.util.Scanner;

public class Candy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution135 s = new Solution135();
        int n = sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.candy(a));
    }
}
class Solution135 {
    public int candy(int[] r) {
        int n=r.length,i,candy=0;
        int []a = new int[n];
        a[0]=1;
        for(i=1;i<n;i++){
            a[i]=1;
            if(r[i]>r[i-1])
                a[i]=a[i-1]+1;
        }

        for(i=n-2;i>=0;i--){
            if(r[i]>r[i+1] && a[i]<=a[i+1])
                a[i]=a[i+1]+1;
        }
        for(i=0;i<n;i++)
            candy+=a[i];
        return candy;
    }
}
