package LeetCode;

import java.util.Scanner;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution29 s = new Solution29();
        System.out.println(s.divide(sc.nextInt(),sc.nextInt()));
    }
}
class Solution29 {// 1ms
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        else if(dividend<0 && divisor<0)
            return (int)divide1(-dividend,-divisor);
        if(dividend>0 && divisor>0)
            return (int)divide1(dividend,divisor);
        else if(dividend<0 && divisor>0)
            return -(int)divide1(-dividend,divisor);
        else
            return -(int)divide1(dividend,-divisor);
    }
    public long divide1(long dividend, long divisor){
        long low=1,high=dividend,mid=(high+low)/2;
        while (low<=high){
            if(mid*divisor>dividend)
                high=mid-1;
            else if(mid*divisor<dividend)
                low=mid+1;
            else
                return mid;
            mid= (high+low)/2;
        }
        return high;
    }
}