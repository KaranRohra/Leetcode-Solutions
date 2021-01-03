package LeetCode;

import java.util.*;

public class AssignCookies {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Solution455 s = new Solution455();
        int n = sc.nextInt();
        int[] g = new int[n];
        for(int i=0;i<n;i++)
            g[i]=sc.nextInt();
        int m = sc.nextInt();
        int[] sa = new int[m];
        for(int i=0;i<m;i++)
            sa[i]=sc.nextInt();
        System.out.println(s.findContentChildren(g,sa));
    }
}
class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length,m=s.length,candy=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=n-1,j=m-1;i>=0 && j>=0;i--){
            if(s[j]>=g[i]){
                candy++;
                j--;
            }
        }
        return candy;
    }
}
