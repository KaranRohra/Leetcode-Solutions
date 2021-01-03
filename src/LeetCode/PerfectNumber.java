package leetCode;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution507 s = new Solution507();
        System.out.println(s.checkPerfectNumber(sc.nextInt()));
    }
}
class Solution507 {
    public boolean checkPerfectNumber(int n) {
        int sum = 1;
        if(n==0 || n==1)
            return false;
        for(int i=2;i*i<n;i++)
            if(n%i==0)
                sum+=i+n/i;
        return sum == n;
    }
}

