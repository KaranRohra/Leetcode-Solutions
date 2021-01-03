package LeetCode;

import java.util.Scanner;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution20 s = new Solution20();
        System.out.println(s.isValid(sc.next()));
    }
}
class Solution20 {
    public boolean isValid(String st) {
        int n=st.length();
        char[] str=st.toCharArray();
        Stack20 s = new Stack20();
        s.push(str[0]);
        for(int i=1;i<n;i++) {
            char x = s.peek();
            if(x!='E') {
                if (str[i] == ')') {
                    if (x != '(')
                        return false;
                    else
                        s.pop();
                } else if (str[i] == '}') {
                    if (x != '{')
                        return false;
                    else
                        s.pop();
                } else if (str[i] == ']') {
                    if (x != '[')
                        return false;
                    else
                        s.pop();
                } else
                    s.push(str[i]);
            }
            else
                s.push(str[i]);
        }
        return s.isEmpty();
    }
}
class Stack20{
    private final int MAX=10000;
    private int top=-1;
    private final char[] stackArray = new char[MAX];
    public void push(char data){
        top++;
        stackArray[top]=data;
    }
    public void pop(){
        top--;
    }
    public char peek(){
        if(top==-1)
            return 'E';
        return stackArray[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
}
