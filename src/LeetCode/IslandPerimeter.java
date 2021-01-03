package leetCode;

import java.util.Scanner;

public class IslandPerimeter {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution463 s = new Solution463();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(s.islandPerimeter(a));
    }
}
class Solution463{
    public int islandPerimeter(int[][] grid) {
        int i,j,n=grid.length,m=grid[0].length,p=0,connect,x,y;
        int [][]a=new int[n+2][m+2];
        for(i=0,x=1;i<n;i++,x++){
            for(j=0,y=1;j<m;j++,y++){
                a[x][y]=grid[i][j];
            }
        }
        for(i=1;i<n+1;i++){
            for(j=1;j<m+1;j++){
                connect=0;
                if(a[i][j]==1){
                    if(a[i][j+1]==0)
                        connect++;
                    if(a[i][j-1]==0)
                        connect++;
                    if(a[i+1][j]==0)
                        connect++;
                    if(a[i-1][j]==0)
                        connect++;
                    p+=connect;
                }
            }
            System.out.println();
        }
        return p;
    }
}