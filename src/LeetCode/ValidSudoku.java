package LeetCode;

import java.util.Scanner;

public class ValidSudoku {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution36 s = new Solution36();
        char [][]board = new char[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println(s.isValidSudoku(board));
    }
}
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]>='1' && board[i][j]<='9'){
                    if(columnSearch(board,j,board[i][j]) || rowSearch(board,i,board[i][j]) || matrixSearch(board,i,j,board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean columnSearch(char [][]str,int j,char x){
        int k=0;
        for(int i=0;i<9;i++){
            if(str[i][j]==x){
                k++;
                if(k>1)
                return true;
            }
        }
        return false;
    }
    public boolean rowSearch(char [][]str,int i,char x){
        int k=0;
        for(int j=0;j<9;j++){
            if(str[i][j]==x) {
                k++;
                if(k>1)
                    return true;
            }
        }
        return false;
    }
    public boolean matrixSearch(char [][]str,int n,int m,int x){
        int s1=0,f1=0,s=0,f=0,k=0;
        if(n<3) {
            s1=0;
            f1=3;
            if (m <= 2)
                f=3;
            else if (m <= 5) {
                s=3;
                f=6;
            }
            else if (m <= 8) {
                s=6;
                f=9;
            }
        }
        else if(n<6){
            s1=3;
            f1=6;
            if (m <= 2)
                f=3;
            else if (m <= 5) {
                s=3;
                f=6;
            }
            else if (m <= 8) {
                s=6;
                f=9;
            }
        }
        else if(n<9){
            s1=6;
            f1=9;
            if (m <= 2)
                f=3;
            else if (m <= 5) {
                s=3;
                f=6;
            }
            else if (m <= 8) {
                s=6;
                f=9;
            }
        }
        for (int i = s1; i < f1; i++) {
            for (int j = s; j < f; j++) {
                if (str[i][j] == x) {
                    k++;
                    if(k>1)
                        return true;
                }
            }
        }
        return false;
    }
}
/*
5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9

output:- true
 */