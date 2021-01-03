package LeetCode;

import java.util.Scanner;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution844 s = new Solution844();
        System.out.println(s.backspaceCompare(sc.next(),sc.next()));
    }
}
class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        int a=0,b=0;
        char[] s=S.toCharArray();
        char[] t=T.toCharArray();
        int n=s.length,m=t.length;
        for(int i=0;i<n;i++){
            if(s[i]=='#' && a!=0)
                a--;
            else if(s[i]>='a' && s[i]<='z')
                s[a++]=s[i];
        }
        for(int i=0;i<m;i++){
            if(t[i]=='#' && b!=0)
                b--;
            else if(t[i]>='a' && t[i]<='z')
                t[b++]=t[i];
        }
        if(a==b)
            return String.valueOf(s).substring(0,a).equals(String.valueOf(t).substring(0,a));
        return false;
    }
}