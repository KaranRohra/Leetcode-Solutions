package leetCode;

import java.util.Scanner;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1337 s = new Solution1337();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] b=s.kWeakestRows(a, sc.nextInt());
        for(int i:b)
            System.out.print(i+" ");
    }
}
class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length,m=mat[0].length;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] result=new int[k];
        for(int i=0;i<n;i++){
            b[i]=i;
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    break;
                a[i]+=mat[i][j];
            }
        }
        insertionSort(a,b,n);
        int i=0;
        while (i!=k){
            result[i]=b[i];
            i++;
        }
        for(int var:b)
            System.out.print(var+" ");
        return result;
    }
    public void insertionSort(int[] a,int[] b,int n){
        for(int i=1;i<n;i++){
            int key=a[i];
            int index=b[i];
            int j=i-1;
            while(j>=0 && a[j]>key) {
                a[j + 1] = a[j];
                b[j + 1] = b[j];
                j--;
            }
            a[j+1]=key;
            b[j+1]=index;
        }
    }
}