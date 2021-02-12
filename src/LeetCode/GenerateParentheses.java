package LeetCode;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}
//https://leetcode.com/problems/generate-parentheses/submissions/
class Solution22 {// 0 ms
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        setGeneratedParenthesis(res,new char[n*2],0,-1);
        return res;
    }
    private void setGeneratedParenthesis(List<String> res,char[] str,int currLength,int top){
        if(currLength>=str.length){
            if(top==-1)
                res.add(new String(str));
            return;
        }

        str[currLength]='(';
        setGeneratedParenthesis(res,str,currLength+1,top+1);

        if(top!=-1){
            str[currLength]=')';
            setGeneratedParenthesis(res,str,currLength+1,top-1);
        }
    }
}



/* Old approach

if length/2 > openBrackets -> (
if length/2 > closeBrackets -> )

*/

