package LeetCode;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        System.out.println(new Solution921().minAddToMakeValid("()))(("));
    }
}
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution921 {// 0 ms
    public int minAddToMakeValid(String S) {
        int count=0;

        int top=-1;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                ++top;// PUSH
            } else if (top != -1) {
                top--;// POP
            } else {
                count++;// INVALID PARENTHESES
            }
        }
        return count + (top + 1);
    }
}