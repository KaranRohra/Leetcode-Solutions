package LeetCode;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution1190().reverseParentheses("(ed(et(oc))el)"));
    }
}
//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
class Solution1190 {// 0 ms
    public String reverseParentheses(String s) {
        char[] str=s.toCharArray();
        int n=str.length;

        int[] stack=new int[n];
        int top=-1;

        for(int i=0;i<n;i++){
            if(str[i]=='('){
                stack[++top]=i;
            }
            else if(str[i]==')'){
                reverse(str,stack[top]+1,i-1);
                top--;
            }
        }
        StringBuilder res=new StringBuilder();
        for (char c : str) {
            if (c != '(' && c != ')') {
                res.append(c);
            }
        }
        return res.toString();
    }
    private void reverse(char[] str,int s,int e){
        while(s<e){
            char temp=str[s];
            str[s]=str[e];
            str[e]=temp;
            e--;
            s++;
        }
    }
}