package leetCode;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Solution189 s = new Solution189();
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        s.rotate(a,k);
        for(int i:a)
            System.out.print(i+" ");
    }
}
class Solution189 {
    public void rotate(int[] b, int k) {
        int n=b.length;
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[(i+k)%n]=b[i];
        }
        for(int i=0;i<n;i++)
            b[i]=a[i];
    }
}
