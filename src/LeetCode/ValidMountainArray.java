package LeetCode;

import java.util.Scanner;

public class ValidMountainArray {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Solution941 s = new Solution941();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.validMountainArray(a));
    }
}
class Solution941 {
    public boolean validMountainArray(int[] a) {
        int n = a.length;
        if (n >= 3) {
            int i;
            for (i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1])
                    break;
                else if (a[i] == a[i + 1])
                    return false;
            }
            if (i > 0 && i != n-1) {
                for (; i < n - 1; i++) {
                    if (a[i] <= a[i + 1])
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
