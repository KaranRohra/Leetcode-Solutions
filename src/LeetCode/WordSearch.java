package LeetCode;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(new Solution79().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        },"ABCCED"));
    }
}
//https://leetcode.com/problems/word-search/
class Solution79 { // 4 ms and 0 incorrect submissions
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(exist(board,w,0,i,j))
                    return true;
            }
        }
        return false;
    }
    private boolean exist(char[][] board,char[] word,int curr,int i,int j){
        if(curr>=word.length)
            return true;
        if(i<0 || j<0 || j>=board[0].length || i>=board.length || board[i][j]!=word[curr]){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='?';
        boolean res=
                exist(board,word,curr+1,i+1,j) ||
                        exist(board,word,curr+1,i-1,j) ||
                        exist(board,word,curr+1,i,j+1) ||
                        exist(board,word,curr+1,i,j-1);

        board[i][j]=temp;
        return res;
    }
}

