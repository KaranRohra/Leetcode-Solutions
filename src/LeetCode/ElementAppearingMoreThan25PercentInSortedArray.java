package LeetCode;

import java.util.Scanner;

public class ElementAppearingMoreThan25PercentInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1287 s = new Solution1287();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(s.findSpecialInteger(a));
    }
}
class Solution1287 {
    public int findSpecialInteger(int[] a) {
        int n=a.length;
        for(int i=0;i<n;i++){
            int x=a[i],count=0;
            while(i<n && x==a[i]){
                i++;
                count++;
            }
            if(count>n/4)
                return x;
            i--;
        }
        return 0;
    }
}
