package LeetCode;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution121 s = new Solution121();
        int n = sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.maxProfit(a));
    }
}
class Solution121 {
    public int maxProfit(int[] prices) {
        int n=prices.length,profit=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                profit=Math.max(prices[j]-prices[i],profit);
            }
        }
        return profit;
    }
}
