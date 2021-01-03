package LeetCode;

import java.util.Scanner;

public class AvailableCapturesForRook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution999 s = new Solution999();
        char[][] b = new char[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                b[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println(s.numRookCaptures(b));
    }
}
class Solution999 {
    public int numRookCaptures(char[][] b) {
        int r1=0,r2=0,count=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(b[i][j]=='R'){
                    r1=i;
                    r2=j;
                    break;
                }
            }
        }
        for(int i=r2-1;i>=0;i--){
            if(b[r1][i]=='p'){
                count++;
                break;
            }
            else if(b[r1][i]=='B')
                break;
        }

        for(int i=r2+1;i<8;i++){
            if(b[r1][i]=='p'){
                count++;
                break;
            }
            else if(b[r1][i]=='B')
                break;
        }

        for(int i=r1-1;i>=0;i--){
            if(b[i][r2]=='p'){
                count++;
                break;
            }
            else if(b[i][r2]=='B')
                break;
        }

        for(int i=r1+1;i<8;i++){
            if(b[i][r2]=='p'){
                count++;
                break;
            }
            else if(b[i][r2]=='B')
                break;
        }
        return count;
    }
}
/*
[[".",".",".",".",".",".",".","."],
[".",".",".","p",".",".",".","."],
[".",".",".","p",".",".",".","."],
["p","p",".","R",".","p","B","."],
[".",".",".",".",".",".",".","."],
[".",".",".","B",".",".",".","."],
[".",".",".","p",".",".",".","."],
[".",".",".",".",".",".",".","."]]
 output: 3
 */
