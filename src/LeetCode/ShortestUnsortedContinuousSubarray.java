package leetCode;

import java.util.Scanner;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution581 s = new Solution581();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(s.findUnsortedSubarray(a));
    }
}
class Solution581 {
    public int findUnsortedSubarray(int[] a) {
        int n=a.length,sl=0,sr=0,x;
        for(int i=0;i<n;i++){
            int min=a[i];
            sl=x=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<=min){
                    min=a[j];
                    x=j;
                }
            }
            if(min!=a[i])// 1 2 3 2 2 3 // 4
                break;
            else if(i<n-1 && a[i+1]!=a[i] && x!=i) {
                sl++;
                break;
            }
        }
        for(int i=n-1;i>=sl;i--){
            int max=a[i];
            sr=x=i;
            for(int j=i-1;j>=0;j--){
                if(a[j]>=max){
                    max=a[j];
                    x=j;
                }
            }
            if(max!=a[i])
                break;
            else if(i>=1 && a[i-1]!=a[i] && x!=i)
                break;
        }
        return sl==sr?0:sr-sl+1;
    }
}