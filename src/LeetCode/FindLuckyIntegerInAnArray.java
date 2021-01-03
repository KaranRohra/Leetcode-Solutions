package LeetCode;

import java.util.Scanner;

public class FindLuckyIntegerInAnArray {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution1394 s=new Solution1394();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.print(s.findLucky(a));
    }
}
class Solution1394 {
    public int findLucky(int[] arr) {
        int []a=new int[501];
        int max=-1;
        for(int i:arr)
            a[i]++;
        for(int i=1;i<501;i++){
            if(a[i]==i && i>=max){
                max=i;
            }
        }
        return max;
    }
}
