package LeetCode;

import java.util.Scanner;

public class CountNumberOfTeams {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Solution1395 s = new Solution1395();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.numTeams(a));
    }
}
class Solution1395 {
    public int numTeams(int[] a) {
        int i,j,k,n=a.length,teams=0;
        for(i=0;i<n-2;i++){
            for(j=i+1;j<n-1;j++){
                if(a[i] < a[j]){
                    for(k=j+1;k<n;k++){
                        if(a[j] < a[k]){
                            teams++;
                        }
                    }
                }
                else if(a[i] > a[j]){
                    for(k=j+1;k<n;k++){
                        if(a[j] > a[k]){
                            teams++;
                        }
                    }
                }
            }
        }
        return teams;
    }
}