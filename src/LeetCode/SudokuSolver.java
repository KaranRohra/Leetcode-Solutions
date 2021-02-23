package LeetCode;

public class SudokuSolver {
    public static void main(String[] args) {
        String[][] stringBoard={
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        char[][] board=new char[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=stringBoard[i][j].charAt(0);
            }
        }
        new Solution37().solveSudoku(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
//https://leetcode.com/problems/sudoku-solver/
class Solution37 { // 5 ms and 0 incorrect submission
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }


    private boolean solveSudoku(char[][] board,int row,int col){
        if(col==9){
            row++;
            if(row==9){
                return true;
            }
            col=0;
        }
        if(board[row][col]!='.'){
            return solveSudoku(board,row,col+1);
        }

        char num='1';
        for(int i=0;i<9;i++){
            if(!isNumberPresent(board,row,col,num)){
                board[row][col]=num;
                if(solveSudoku(board,row,col+1)){
                    return true;
                }
                board[row][col]='.';
            }
            num++;
        }
        return false;
    }

    private boolean isNumberPresent(char[][] board,int row,int col,char num){
        for(int i=0;i<9;i++){
            if(board[i][col]==num || board[row][i]==num){
                return true;
            }
        }

        if(row<3){
            if(col<3){
                return isNumberPresentInSubBlock(board,0,0,num);
            }else if(col<6){
                return isNumberPresentInSubBlock(board,0,3,num);
            }else{// if(col<9)
                return isNumberPresentInSubBlock(board,0,6,num);
            }

        }else if(row<6){
            if(col<3){
                return isNumberPresentInSubBlock(board,3,0,num);
            }else if(col<6){
                return isNumberPresentInSubBlock(board,3,3,num);
            }else{// if(col<9)
                return isNumberPresentInSubBlock(board,3,6,num);
            }

        }else{// if(row < 9)
            if(col<3){
                return isNumberPresentInSubBlock(board,6,0,num);
            }else if(col<6){
                return isNumberPresentInSubBlock(board,6,3,num);
            }else{// if(col<9)
                return isNumberPresentInSubBlock(board,6,6,num);
            }
        }

    }

    private boolean isNumberPresentInSubBlock(char[][] board,int row,int col,int num){
        for(int i=0;i<3;i++){
            for(int j=0,k=col;j<3;j++,k++){
                if(board[row][k]==num){
                    return true;
                }
            }
            row++;
        }
        return false;
    }
}



