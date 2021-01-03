package LeetCode;

import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution125 s = new Solution125();
        System.out.println(s.isPalindrome(sc.nextLine()));
    }
}
class Solution125 {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().trim();
        if(s.equals(""))
            return true;
        int n=s.length();
        char []str=new char[n];
        int k=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c>='a' && c<='z' || c>='0' && c<='9')
                str[k++]=c;
        }
        if(k==0)
            return true;
        for(int i=0;i<=k/2;i++){
            if(str[i]!=str[k-i-1])
                return false;
        }
        return true;
    }
}

