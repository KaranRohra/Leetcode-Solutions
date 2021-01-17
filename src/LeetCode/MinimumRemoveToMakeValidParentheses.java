package LeetCode;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution1249().minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/
class Solution1249 {// 7 ms
    public String minRemoveToMakeValid(String s) {
        char[] str=s.toCharArray();
        int top=-1,n=str.length;
        int[] stack=new int[n];

        for(int i=0;i<n;i++){
            if(str[i]=='('){
                stack[++top]=i;
            }
            else if(str[i]==')'){
                if(top!=-1){
                    top--;
                }
                else{
                    str[i]='!';
                }
            }
        }
        while(top!=-1){
            str[stack[top--]]='!';
        }
        int k=0;
        for(int i=0;i<n;i++){
            char c=str[i];
            if(c!='!')
                str[k++]=c;
        }
        return new String(str).substring(0,k);
    }
}
