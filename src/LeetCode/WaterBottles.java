package LeetCode;

import java.util.Scanner;

public class WaterBottles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution1518 s = new Solution1518();
        System.out.println(s.numWaterBottles(sc.nextInt(),sc.nextInt()));
    }
}
class Solution1518 {
    public int numWaterBottles(int nBottles, int nExchange) {
        int drinks = nBottles;
        int pBottles = nBottles; // Present Bottles
        while(pBottles >= nExchange){
            drinks+=pBottles/nExchange;
            pBottles = pBottles/nExchange + pBottles%nExchange;
        }
        return drinks;
    }
}
