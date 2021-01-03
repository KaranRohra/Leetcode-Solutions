package LeetCode;

import java.util.Scanner;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution1295 s = new Solution1295();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.findNumbers(a));
    }
}
class Solution1295 {
    public int findNumbers(int[] nums) {
        int count=0;
        String str;
        for(int i:nums){
            str=String.valueOf(i);
            if(str.length()%2==0)
                count++;
        }
        return count;
    }
}