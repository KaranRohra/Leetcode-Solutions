package leetCode;

import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution58 s = new Solution58();
        System.out.println(s.lengthOfLastWord(sc.nextLine()));
    }
}
class Solution58 {
    public int lengthOfLastWord(String s) {
        int length=0,n=s.length(),i=n-1;
        while(i>=0 && s.charAt(i)==' ')
            i--;
        while(i>=0 && s.charAt(i--)!=' ')
            length++;
        return length;
    }
}