package LeetCode;

import java.util.*;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution202().isHappy(2));
    }
}
//https://leetcode.com/problems/happy-number/
class Solution202 {// 1 ms
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(true){
            set.add(n);
            int nums=n;
            int sum=0;
            while(nums!=0){
                sum+=(nums%10)*(nums%10);
                nums/=10;
            }
            if(sum==1)
                return true;
            if(set.contains(sum))
                return false;
            n=sum;
        }
    }
}

