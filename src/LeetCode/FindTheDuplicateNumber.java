package LeetCode;

import java.util.Scanner;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution287 s = new Solution287();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.findDuplicate(a));
    }
}
class Solution287 {
    public int findDuplicate(int[] nums) {
        int  n = nums.length;
        int[] c = new int[n+1];
        for(int i : nums){
            c[i]++;
            if(c[i]==2)
                return i;
        }
        return 0;
    }
}
