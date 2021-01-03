package LeetCode;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution1021().removeOuterParentheses("(()())(())(()(()))"));
    }
}
//https://leetcode.com/problems/remove-outermost-parentheses/submissions/
class Solution1021 {// 2 ms
    public String removeOuterParentheses(String S) {
        char[] str=S.toCharArray();
        StringBuilder ans=new StringBuilder();

        int count=0;
        for (char c : str) {
            if (c == '(') {
                if (count != 0)
                    ans.append('(');
                count++;
            } else if (count == 1) {
                count--;
            } else if (count != 0) {
                ans.append(')');
                count--;
            }
            //System.out.println(stack);
        }
        return ans.toString();
    }
}