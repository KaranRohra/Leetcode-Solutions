package leetCode;

import java.util.Scanner;

public class SetMatrixZeroes {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution73 s = new Solution73();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        s.setZeroes(a);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class Solution73 {
    private int[] n;
    private int[] m;

    public void setZeroes(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        n = new int[a * b];
        m = new int[b * a];
        int k = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == 0) {
                    n[k] = i;
                    m[k++] = j;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            rowZero(matrix, n[i], b);
            columnZero(matrix, m[i], a);
        }
    }

    public void rowZero(int[][] a, int i, int m) {
        for (int j = 0; j < m; j++)
            a[i][j] = 0;
    }

    public void columnZero(int[][] a, int j, int n) {
        for (int i = 0; i < n; i++)
            a[i][j] = 0;
    }
}
