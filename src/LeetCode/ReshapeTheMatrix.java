package leetCode;

import java.util.Scanner;

public class ReshapeTheMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution566 s = new Solution566();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]a= new int [n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j]=sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        a = s.matrixReshape(a,r,c);
        for(int []i : a){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums[0].length * nums.length != r * c)
            return nums;
        int[][] a = new int[r][c];
        int[] temp = new int[r * c];
        int k = 0;
        for (int[] i : nums)
            for (int j : i)
                temp[k++] = j;
        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = temp[k++];
            }
        }
        return a;
    }
}