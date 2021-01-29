package LeetCode;

import java.util.*;

public class QueensThatCanAttackTheKing {
    public static void main(String[] args) {
        System.out.println(new Solution1222().queensAttacktheKing(new int[][]{
                {0, 1},{1,0},{4,0},{0,4},{3,3},{2,4}
        },new int[]{
                0,0
        }));
    }
}
//https://leetcode.com/problems/queens-that-can-attack-the-king/
class Solution1222 {// 1 ms
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> attackQueens = new ArrayList<>();
        boolean[][] board = new boolean[8][8];

        // true represent queen in board
        for (int[] i : queens) {
            board[i[0]][i[1]] = true;
        }

        //left queen of king
        for (int i = king[1] + 1; i < 8; i++) {
            if (board[king[0]][i]) {
                attackQueens.add(getList(king[0], i));
                break;
            }
        }

        //right queen of king
        for (int i = king[1] - 1; i >= 0; i--) {
            if (board[king[0]][i]) {
                attackQueens.add(getList(king[0], i));
                break;
            }
        }

        //top queen of king
        for (int i = king[0] - 1; i >= 0; i--) {
            if (board[i][king[1]]) {
                attackQueens.add(getList(i, king[1]));
                break;
            }
        }

        //bottom queen of king
        for (int i = king[0] + 1; i < 8; i++) {
            if (board[i][king[1]]) {
                attackQueens.add(getList(i, king[1]));
                break;
            }
        }

        //left top queen of king
        for (int i = king[0], j = king[1]; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                attackQueens.add(getList(i, j));
                break;
            }
        }

        //right bottom queen of king
        for (int i = king[0], j = king[1]; i < 8 && j < 8; i++, j++) {
            if (board[i][j]) {
                attackQueens.add(getList(i, j));
                break;
            }
        }

        //left bottom queen of king
        for (int i = king[0], j = king[1]; i < 8 && j >= 0; i++, j--) {
            if (board[i][j]) {
                attackQueens.add(getList(i, j));
                break;
            }
        }

        //right top queen of king
        for (int i = king[0], j = king[1]; i >= 0 && j < 8; i--, j++) {
            if (board[i][j]) {
                attackQueens.add(getList(i, j));
                break;
            }
        }
        return attackQueens;
    }

    private List<Integer> getList(int i, int j) {
        List<Integer> ans = new ArrayList<>();
        ans.add(i);
        ans.add(j);
        return ans;
    }
}








