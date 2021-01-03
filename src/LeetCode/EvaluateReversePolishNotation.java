package LeetCode;

import java.util.*;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution150 s = new Solution150();
        int n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;i++)
            a[i]=sc.next();
        System.out.println(s.evalRPN(a));
    }
}
class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operandStack=new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(0);
            if(c=='+' && token.length()>1)
                operandStack.push(Integer.parseInt(token));
            else if(c=='-' && token.length()>1)
                operandStack.push(Integer.parseInt(token));
            else if (c >= '0' && c <= '9' )
                operandStack.push(Integer.parseInt(token));
            else {
                int a = operandStack.pop();
                int b = operandStack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        operandStack.push(b + a);
                        break;
                    case '-':
                        operandStack.push(b - a);
                        break;
                    case '*':
                        operandStack.push(b * a);
                        break;
                    case '/':
                        operandStack.push(b / a);
                        break;
                }
            }
        }
        return operandStack.pop();
    }
}
