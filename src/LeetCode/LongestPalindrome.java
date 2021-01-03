package leetCode;

import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution409 s = new Solution409();
        System.out.println(s.longestPalindrome(sc.next()));
    }
}
class Solution409 {
    public int longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int length=0;
        int[] a = new int[26];
        int[] A = new int[26];
        for (char c : str) {
            if (c >= 'a' && c <= 'z')
                a[c - 'a']++;
            else
                A[c - 'A']++;
        }
        for(int i=0;i<26;i++){
            if(a[i]%2 != 0){
                a[i]--;
                length++;
                break;
            }
            if(A[i]%2 != 0){
                A[i]--;
                length++;
                break;
            }
        }
        for(int i=0;i<26;i++){
            if(a[i]%2!=0)
                a[i]--;
            if(A[i]%2!=0)
                A[i]--;
            length+=a[i]+A[i];
        }
        return length;
    }
}
