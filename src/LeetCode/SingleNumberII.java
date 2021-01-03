package leetCode;

import java.util.*;

public class SingleNumberII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution137 s = new Solution137();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        System.out.println(s.singleNumber(a));
    }
}
class Solution137 {
    public int singleNumber(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        if(n==1)
            return a[0];
        if(a[0]!=a[1])
            return a[0];
        for(int i=1;i<n-1;i++){
            if(a[i+1]!=a[i] && a[i-1]!=a[i])
                return a[i];
        }
        if(a[n-1]!=a[n-2])
            return a[n-1];
        return 0;
    }
}
