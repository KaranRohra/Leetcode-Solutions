package leetCode;

import java.util.Scanner;

public class ToeplitzMatrix {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution766 s = new Solution766();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j]=sc.nextInt();
        System.out.println(s.isToeplitzMatrix(a));
    }
}
class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length,i,j;
        for(i=0;i<n-1;i++){
            for(j=0;j<m-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}