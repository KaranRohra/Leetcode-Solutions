package LeetCode;

import java.util.Scanner;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1598 s = new Solution1598();
        int n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;i++)
            a[i]=sc.next();
        System.out.println(s.minOperations(a));
    }
}
class Solution1598 {// 0ms
    public int minOperations(String[] logs) {
        int count=0;
        for (String log : logs) {
            if (log.equals("../") && count != 0)
                count--;
            else {
                char c = log.charAt(0);
                if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
                    count++;
            }
        }
        return count;
    }
}
