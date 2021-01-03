package LeetCode;

import java.util.Scanner;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution605 s = new Solution605();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.canPlaceFlowers(a,sc.nextInt()));
    }
}
class Solution605 {
    public boolean canPlaceFlowers(int[] a, int n) {
        int flower=0,m=a.length;
        if(m==1){ // Edges Condition
            if(a[0]==1)
                return n == 0;
            return true;
        }
        for(int i=0;i<m;i++){
            if(i==0){
                if(a[i]==0 && a[i+1]!=1){
                    flower++;
                    a[i]=1;
                }
            }
            else if(i==m-1){
                if(a[i]==0 && a[i-1]!=1){
                    flower++;
                    a[i]=1;
                }

            }
            else if(a[i]==0 && a[i-1]!=1 && a[i+1]!=1) {
                a[i]=1;
                flower++;
            }
        }
        return flower>=n;
    }
}
