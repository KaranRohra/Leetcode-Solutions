package LeetCode;

public class BaseballGame {
    public static void main(String[] args) {
        System.out.println(new Solution682().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
//https://leetcode.com/problems/baseball-game/
class Solution682 {// 1 ms
    public int calPoints(String[] ops) {
        int n=ops.length;
        int[] stack=new int[n];
        int top=-1;
        for (String op : ops) {
            switch (op) {
                case "+":
                    int v1 = stack[top - 1];
                    int v2 = stack[top];
                    top++;
                    stack[top] = v1 + v2;
                    break;
                case "C":
                    top--;
                    break;
                case "D":
                    int v = stack[top] * 2;
                    top++;
                    stack[top] = v;
                    break;
                default:
                    v = Integer.parseInt(op);
                    top++;
                    stack[top] = v;
            }
        }
        int sum=0;
        while(top!=-1){
            sum+=stack[top--];
        }
        return sum;
    }
}