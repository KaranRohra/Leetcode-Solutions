package leetCode;

import java.util.*;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var s = new Solution378();
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(s.kthSmallest(a, sc.nextInt()));
    }
}
class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length,m=0;
        int []a = new int[n*n];
        for(int[] i:matrix){
            for(int j:i){
                a[m++]=j;
            }
        }
        Arrays.sort(a);
        return a[k-1];
    }
}

