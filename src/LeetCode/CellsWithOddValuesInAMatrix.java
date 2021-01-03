package LeetCode;

import java.util.Scanner;

public class CellsWithOddValuesInAMatrix {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var s = new Solution1252();
        int row = sc.nextInt();
        int[][] a = new int[row][2];
        for(int i=0;i<row;i++){
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        System.out.println(s.oddCells(sc.nextInt(),sc.nextInt(),a));
    }
}
class Solution1252 {
    public int oddCells(int n, int m, int[][] in) {
        int[][] a = new int[n][m];
        for (int[] ints : in)
            inc(a, n, m, ints[0], ints[1]);
        return oddCheck(a,n,m);
    }
    public void inc(int[][] a,int n,int m,int x,int y){
        for(int i=0;i<m;i++)
            a[x][i]++;
        for(int i=0;i<n;i++)
            a[i][y]++;
    }
    public int oddCheck(int[][] a,int n,int m){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]%2==1)
                    count++;
            }
        }
        return count;
    }
}