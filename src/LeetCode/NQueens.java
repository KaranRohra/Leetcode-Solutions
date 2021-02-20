package LeetCode;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }
}
//https://leetcode.com/problems/n-queens/
class Solution51 {// 3 ms and 0 incorrect submissions
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();

        solveNQueens(res,new boolean[n][n],0,n);

        return res;
    }

    private void solveNQueens(List<List<String>> res,boolean[][] board,int row,int n){
        if(n==0){
            res.add(makeBoard(board));
            return;
        }

        for(int i=0;i<board.length;i++){
            if(!isQueenPresent(board,row,i)){
                board[row][i]=true;
                solveNQueens(res,board,row+1,n-1);
                board[row][i]=false;
            }
        }
    }

    private boolean isQueenPresent(boolean[][] board,int row,int col){
        int n=board.length;
        for (boolean[] booleans : board) {
            if (booleans[col]) {
                return true;
            }
        }
        for(int i=row,j=col;i<n && j<n;i++,j++){
            if(board[i][j])
                return true;
        }
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j])
                return true;
        }
        for(int i=row,j=col;i<n && j>=0;i++,j--){
            if(board[i][j])
                return true;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j])
                return true;
        }

        return false;
    }

    private List<String> makeBoard(boolean[][] board){
        List<String> res=new ArrayList<>();

        int n=board.length;
        for (boolean[] booleans : board) {
            char[] temp = new char[n];
            for (int j = 0; j < n; j++) {
                if (booleans[j]) {
                    temp[j] = 'Q';
                } else {
                    temp[j] = '.';
                }
            }
            res.add(new String(temp));
        }
        return res;
    }
}


