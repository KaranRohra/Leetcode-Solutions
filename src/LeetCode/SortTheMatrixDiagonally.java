package LeetCode;

import java.util.*;

public class SortTheMatrixDiagonally {
    public static void main(String[] args) {
        int[][] res=new Solution1329().diagonalSort(new int[][]{
                {3,3,1,1},{2,2,1,2},{1,1,1,2}
        });
        for(int[] i:res){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
//https://leetcode.com/problems/sort-the-matrix-diagonally/submissions/
class Solution1329 {// 2 ms
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length,m=mat[0].length;

        int col=0,row=0;
        while(col<m){
            sort(mat,n,m,0,col);
            col++;
        }
        while(row<n){
            sort(mat,n,m,row,0);
            row++;
        }
        return mat;
    }
    private void sort(int[][] matrix,int n,int m,int row,int col){
        int[] temp=new int[101];
        int length=0;

        for(int i=row,j=col,k=0;i<n && j<m;j++,i++,k++){
            temp[k]=matrix[i][j];
            length++;
        }
        Arrays.sort(temp);
        for(int i=row,j=col,k=101-length;i<n && j<m;j++,i++,k++){
            matrix[i][j]=temp[k];
        }
    }
}