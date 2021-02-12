package LeetCode;

public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid=new char[4][5];

        String[][] temp={
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=temp[i][j].charAt(0);
            }
        }

        System.out.println(new Solution200().numIslands(grid));
    }
}
//https://leetcode.com/problems/number-of-islands/
class Solution200 { // 1 ms
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res+=findIslands(grid,i,j);
            }
        }
        return res;
    }
    private int findIslands(char[][] grid,int i,int j){
        if(i>=grid.length || j>=grid[0].length || j<0 || i<0 || grid[i][j]=='0')
            return 0;
        grid[i][j]='0';

        findIslands(grid,i+1,j);
        findIslands(grid,i,j+1);
        findIslands(grid,i-1,j);
        findIslands(grid,i,j-1);
        return 1;
    }

    /*
    [
    ["1","1","1"],
    ["0","1","0"],
    ["1","1","1"]
    ]
    */
}