package LeetCode;

import java.util.Scanner;

public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Solution1475 s = new Solution1475();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        a=s.finalPrices(a);
        for(int i:a)
            System.out.println(i+" ");
    }
}
class Solution1475 {
    public int[] finalPrices(int[] a) {
        int i,j,n=a.length;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                if(a[j]<=a[i]){
                    a[i]=a[i]-a[j];
                    break;
                }
            }
        }
        return a;
    }
}