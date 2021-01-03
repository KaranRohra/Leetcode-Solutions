package leetCode;

import java.util.Scanner;

public class Sqrtx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution69 s = new Solution69();
        System.out.println(s.mySqrt(sc.nextInt()));
    }
}
class Solution69 {
    public int mySqrt(int x) {
        int low=1,high=x,mid;
        while (low<=high) {
            mid = (high + low) / 2;
            if (mid * mid > x)
                high = mid - 1;
            else if (mid * mid < x)
                low = mid + 1;
            else
                return mid;
        }
        return high;
    }
}