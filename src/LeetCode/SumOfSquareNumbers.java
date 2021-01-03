package LeetCode;

import java.util.Scanner;

public class SumOfSquareNumbers {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution633 s = new Solution633();
        System.out.println(s.judgeSquareSum(sc.nextInt()));
    }
}
class Solution633 {
    public boolean judgeSquareSum(int n) {
        for(int i=0;i*i<=n/2;i++){
            int a=i*i;
            int b=n-a;
            double c=Math.sqrt(b);
            if(Math.ceil(c) == Math.floor(c))
                return true;
        }
        return false;
    }
}
