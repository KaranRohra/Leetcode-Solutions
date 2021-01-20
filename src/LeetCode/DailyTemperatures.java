package LeetCode;

import java.util.Arrays;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
//https://leetcode.com/problems/daily-temperatures/
class Solution739 {// 3 ms
    public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        int[] res=new int[n];

        int[] stack=new int[n];
        int top=-1;

        res[n-1]=0;
        stack[++top]=n-1;
        for(int i=n-2;i>=0;i--){
            while(top!=-1 && T[stack[top]]<=T[i]){
                top--;
            }
            if(top==-1)
                res[i]=0;
            else
                res[i]=stack[top]-i;
            stack[++top]=i;
        }

        return res;
    }
}