package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution867 s = new Solution867();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]a=new int[n][];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            a[i][j]=sc.nextInt();
        a=s.transpose(a);
        for(int []i:a)
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        String []word={"Karan, Anisha","Khushboo"};
        char []str=word[0].toLowerCase().toCharArray();
    }
}
class Solution867 {
    public int[][] transpose(int[][] A) {
        int n=A.length,m=A[0].length;
        int [][]result;
        if(n==m){
            result=new int [n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    result[i][j]=A[j][i];
                }
            }
        }
        else{
            result=new int [m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    result[i][j]=A[j][i];
                }
            }
        }
        return result;
    }
}