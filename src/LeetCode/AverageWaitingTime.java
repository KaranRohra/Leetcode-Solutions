package LeetCode;

public class AverageWaitingTime {
    public static void main(String[] args) {
        System.out.println(new Solution1701().averageWaitingTime(new int[][]{
                {5,2},
                {5,4},
                {10,3},
                {20,1}
        }));
    }
}
//https://leetcode.com/problems/average-waiting-time/
class Solution1701 {
    public double averageWaitingTime(int[][] customers) {
        long sum=0,totalTime=0;
        int n=customers.length;
        for (int[] customer : customers) {
            if (totalTime < customer[0]) {
                sum += customer[1];
                totalTime = customer[1] + customer[0];
            } else {
                totalTime += customer[1];
                sum += totalTime - customer[0];
            }
        }
        return sum*1.0/n;
    }
}
/*
s->2,6,4,1
t->7,11,14,21
*/