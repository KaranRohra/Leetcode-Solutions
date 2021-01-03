package leetCode;

import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution35 s = new Solution35();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int t=sc.nextInt();
        System.out.println(s.searchInsert(a,t));
    }
}
class Solution35 {
    public int searchInsert(int[] a, int t) {
        int n=a.length;
        for(int i=0;i<n-1;i++){
            if(a[i]==t)
                return i;
            else if(a[i]<t && a[i+1]>=t)
                return i+1;
        }
        if(a[n-1]<t)
            return n;
        return 0;
    }
}
