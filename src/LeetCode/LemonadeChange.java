package LeetCode;

public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(new Solution860().lemonadeChange(new int[]{5,5,5,10,20}));
    }
}
//https://leetcode.com/problems/lemonade-change/submissions/
class Solution860 {// 2 ms
    public boolean lemonadeChange(int[] bills) {
        int[] change=new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                change[0]++;
            } else if (bill == 10) {
                if (change[0] == 0) {
                    return false;
                }
                change[0]--;
                change[1]++;
            } else {
                change[2]++;
                if (change[0] >= 1 && change[1] >= 1) {
                    change[0]--;
                    change[1]--;
                    continue;
                } else if (change[0] >= 3) {
                    change[0] -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
class Solution860Recursive {// 28 ms
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;

        return lemonadeChange(bills,0,0,0,0);
    }
    private boolean lemonadeChange(int[] bills,int i,int change5,int change10,int change20){
        if(i>=bills.length){
            return true;
        }
        if(bills[i]==5){
            return lemonadeChange(bills,i+1,change5+1,change10,change20);
        }
        else if(bills[i]==10){
            if(change5==0){
                return false;
            }
            return lemonadeChange(bills,i+1,change5-1,change10+1,change20);
        }
        else{
            if(change5>=3){
                if(lemonadeChange(bills,i+1,change5-3,change10,change20+1))
                    return true;
            }

            if(change5>=1 && change10>=1){
                if(lemonadeChange(bills,i+1,change5-1,change10-1,change20+1))
                    return true;
            }

            return false;
        }
    }
}
