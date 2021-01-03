package leetCode;

import java.util.Scanner;

public class MonotonicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution896 s = new Solution896();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.isMonotonic(a));
    }
}
class Solution896 {
    public boolean isMonotonic(int[] a) {
        int n = a.length, i = 0;
        boolean isGreater = false;
        if (n == 1)
            return true;

        while (i < n - 1 && a[i] == a[i + 1])
            i++;
        if (i == n - 1)
            return true;
        if (a[i] > a[i + 1])
            isGreater = true;

        if (isGreater) {
            for (i = 0; i < n - 1; i++) {
                if (a[i] < a[i + 1])
                    return false;
            }
        } else {
            for (i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1])
                    return false;
            }
        }
        return true;
    }
}