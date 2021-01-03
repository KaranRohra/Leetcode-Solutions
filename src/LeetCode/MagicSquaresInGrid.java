package leetCode;

import java.util.Scanner;

public class MagicSquaresInGrid {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution840 s = new Solution840();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j]=sc.nextInt();
        System.out.print(s.numMagicSquaresInside(a));
    }
}
class Solution840 {
    private final int [][][]magic={//new int[8][9][9];
            {
                    {2,9,4},
                    {7,5,3},
                    {6,1,8},
            },
            {
                    {4,9,2},
                    {3,5,7},
                    {8,1,6},
            },
            {
                    {6,1,8},
                    {7,5,3},
                    {2,9,4},
            },
            {
                    {2,7,6},
                    {9,5,1},
                    {4,3,8}
            },
            {
                    {6,7,2},
                    {1,5,9},
                    {8,3,4},
            },
            {
                    {4,3,8},
                    {9,5,1},
                    {2,7,6}
            },
            {
                    {8,3,4},
                    {1,5,9},
                    {6,7,2}
            },
            {
                    {8,1,6},
                    {3,5,7},
                    {4,9,2}
            }
    };
    public int numMagicSquaresInside(int[][] grid) {
        int i,j,n=grid.length,m=grid[0].length,count=0;
        for(i=0;i<=n-3;i++){
            for(j=0;j<=m-3;j++){
                if(searchMagic(grid,i,j,i+3,j+3))
                    count++;
            }
        }
        return count;
    }
    public boolean searchMagic(int [][]a,int s1,int s2,int n,int m){
        for(int i=0;i<8;i++){
            if(compare(a,magic[i],s1,s2,n,m))
                return true;
        }
        return false;
    }
    public boolean compare(int [][]a,int [][]b,int s1,int s2,int n,int m){
        int i,j,x,y;
        for(i=s1,x=0;i<n;i++,x++){
            for(j=s2,y=0;j<m;j++,y++){
                if(a[i][j]!=b[x][y])
                    return false;
            }
        }
        return true;
    }
}
/*
        4 3 8 4
        9 5 1 9
        2 7 6 2
 */