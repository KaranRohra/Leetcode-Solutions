package leetCode;

import java.util.Scanner;

public class SearchA2DMatrix {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution74 s = new Solution74();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(s.searchMatrix(a,3));
    }
}
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int t) {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        for (int[] ints : matrix) {
            int n=ints.length;
            if (ints[0] <= t && ints[n - 1] >= t)
                return Search(ints, n, t);
        }
        return false;
    }
    public boolean Search(int []a,int n,int x){
        for(int i=0;i<n;i++){
            if(a[i]==x)
                return true;
        }
        return false;
    }
}
