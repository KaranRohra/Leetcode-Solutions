package LeetCode;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(new Solution414().thirdMax(new int[]{1,Integer.MIN_VALUE,2}));
    }
}
//https://leetcode.com/problems/third-maximum-number/submissions/
class Solution414 {
    public int thirdMax(int[] A) {
        long firstMax=Long.MIN_VALUE,secondMax=Long.MIN_VALUE,thirdMax=Long.MIN_VALUE;

        for (int j : A) {
            if (j > thirdMax && firstMax > j && secondMax > j) {
                thirdMax = j;
            } else if (j > secondMax && firstMax > j) {
                thirdMax = secondMax;
                secondMax = j;
            } else if (j > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = j;
            }
        }
        return (int)(thirdMax==Long.MIN_VALUE?firstMax:thirdMax);
    }
}