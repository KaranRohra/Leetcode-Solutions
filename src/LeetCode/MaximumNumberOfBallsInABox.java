package LeetCode;

public class MaximumNumberOfBallsInABox {
    public static void main(String[] args) {
        System.out.println(new Solution1742().countBalls(1,10));
    }
}
//https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
class Solution1742 {// 20 ms
    public int countBalls(int lowLimit, int highLimit) {
        int[] ballCount=new int[50];
        int max=0;
        for(int i=lowLimit;i<=highLimit;i++){
            int x=i,sum=0;
            while(x!=0){
                sum+=x%10;
                x/=10;
            }
            ballCount[sum]++;
            if(ballCount[sum]>max){
                max=ballCount[sum];
            }
        }
        return max;
    }
}