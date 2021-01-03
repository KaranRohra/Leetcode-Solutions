package LeetCode;

import java.util.Scanner;

public class BuddyStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution859 s = new Solution859();
        System.out.println(s.buddyStrings(sc.next(),sc.next()));
    }
}
class Solution859 {
    public boolean buddyStrings(String A, String B) {
        int n = A.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[] c = new int [26];
        if(n!=b.length)
            return false;
        if(A.equals(B)){
            for(int i=0;i<n;i++) c[a[i]-'a']++;
            for(int i=0;i<26;i++){
                if(c[i]>=2)
                    return true;
            }
            return false;
        }
        int count=0;
        char x1='1',y1='2',y2='3',x2='4';
        for(int i=0;i<n;i++){
            if(a[i]!=b[i]){
                count++;
                if(count>2)
                    return false;
                if(count==1){
                    x1=a[i];
                    y1=b[i];
                }
                else{
                    x2=a[i];
                    y2=b[i];
                }
            }
        }
        return (x1==y2 && x2==y1);
    }
}
