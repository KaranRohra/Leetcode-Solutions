package LeetCode;

import java.util.Scanner;

public class FlippingAnImage {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution832 s = new Solution832();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                a[i][j]=sc.nextInt();
        a=s.flipAndInvertImage(a);
        for(int []i:a){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n=A.length,m=A[0].length;
        int [][]a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0,k=m-1;j<m;j++,k--){
                a[i][j]=A[i][k];
                if(a[i][j]==1)
                    a[i][j]=0;
                else
                    a[i][j]=1;
            }
        }
        return a;
    }
}