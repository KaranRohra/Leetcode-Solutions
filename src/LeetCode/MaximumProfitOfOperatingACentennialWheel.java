package leetCode;

import java.util.Scanner;

public class MaximumProfitOfOperatingACentennialWheel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Solution1599 s=new Solution1599();
        int[] customers=new int[sc.nextInt()];
        System.out.println(s.minOperationsMaxProfit(customers,sc.nextInt(),sc.nextInt()));
    }
}
class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length,profit, totalBoard = 0, wait = 0,i,max=0,maxRotation=-1;
        for (i = 0; i < n; i++) {
            wait += customers[i];
            if (wait > 4) {
                wait -= 4;
                totalBoard += 4;
            } else {
                totalBoard += wait;
                wait = 0;
            }
            profit=totalBoard*boardingCost-(i+1)*runningCost;
            if(profit > max) {
                max = profit;
                maxRotation = i+1;
            }
        }
        while (wait!=0){
            if (wait > 4) {
                wait -= 4;
                totalBoard += 4;
            } else {
                totalBoard += wait;
                wait = 0;
            }
            profit=totalBoard*boardingCost-(i+1)*runningCost;
            if(profit > max) {
                max = profit;
                maxRotation = i+1;
            }
            i++;
        }
        return maxRotation;
    }
}