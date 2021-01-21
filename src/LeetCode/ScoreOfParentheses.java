package LeetCode;

public class ScoreOfParentheses {// VVV Interesting
    public static void main(String[] args) {
        System.out.println(new Solution856().scoreOfParentheses("(()(()))"));
    }
}
//https://leetcode.com/problems/score-of-parentheses/
// remember stack is not only for brackets
class Solution856 {// 0 ms
    public int scoreOfParentheses(String S) {
        char[] str = S.toCharArray();
        int n = str.length;

        int[] stack = new int[n];
        int top = -1;
        for (char c : str) {
            if (c == '(') {
                stack[++top] = -1;
            } else {
                int currScore = 0;
                while (top != -1 && stack[top] >= 0) {
                    currScore += stack[top--];
                }
                top--;
                if (currScore == 0) {
                    stack[++top] = 1;
                } else {
                    stack[++top] = currScore * 2;
                }
            }
        }
        int score = 0;
        while (top != -1) {
            score += stack[top--];
        }
        return score;
    }
}