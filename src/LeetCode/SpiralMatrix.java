package leetCode;

import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution54 s = new Solution54();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(s.spiralOrder(a));
    }
}
class Solution54{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a = new LinkedList<>();
        if(matrix.length==0)
            return a;
        int n=matrix.length,m=matrix[0].length,s1=0,e1=m-1,s2=1,e2=n-2;
        int[] result=new int[n*m];
        int r1=0,r2=n-1,c1=m-1,c2=0,k=0;
        boolean p=true;
        loop1:
        while (p){
            p=false;
            for(int i=s1;i<=e1;i++) {
                try {
                    result[k++]=matrix[r1][i];
                }
                catch (Exception e){
                    break loop1;
                }
                p=true;
            }
            for(int i=s2;i<=e2;i++) {
                try {
                    result[k++]=matrix[i][c1];
                }
                catch (Exception e){
                    break loop1;
                }
                p=true;
            }
            for(int i=e1;i>=s1;i--) {
                try {
                    result[k++]=matrix[r2][i];
                }
                catch (Exception e){
                    break loop1;
                }
                p=true;
            }
            for(int i=e2;i>=s2;i--) {
                try {
                    result[k++]=matrix[i][c2];
                }
                catch (Exception e){
                    break loop1;
                }
                p=true;
            }
            s1++;
            e1--;
            s2++;
            e2--;
            r1++;
            r2--;
            c1--;
            c2++;
        }
        for (int j : result) a.add(j);
        return a;
    }
}