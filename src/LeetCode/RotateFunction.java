package leetCode;

import java.util.Scanner;

public class RotateFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution396 s = new Solution396();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.maxRotateFunction(a));
    }
}
class Solution396 {
    public int maxRotateFunction(int[] a) {
        int max = 0,n = a.length,i,j,sum,x;
        for(i=0;i<n;i++)
            max+=a[i]*i;
        for(i=1;i<n;i++){
            sum=0;
            for(j=0;j<n;j++){
                x=(i+j)%n;
                sum+=a[j]*x;
            }
            if(sum>max)
                max=sum;
        }
        return max;
    }
}