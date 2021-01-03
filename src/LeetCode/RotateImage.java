package leetCode;

import java.util.Scanner;

public class RotateImage {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution48 s = new Solution48();
        int n=sc.nextInt();
        int [][]a=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=sc.nextInt();
        s.rotate(a);
        for(int []i:a){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][]a=new int[n][n];
        for(int i=0,x=0;i<n;i++,x++){
            for(int j=n-1,y=0;j>=0;j--,y++){
                a[x][y]=matrix[j][i];
            }
        }
        for(int i=0;i<n;i++){
            System.arraycopy(a[i], 0, matrix[i], 0, n);
        }
    }
}