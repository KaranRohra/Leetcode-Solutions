package LeetCode;

import java.util.Scanner;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1455 s = new Solution1455();
        System.out.println(s.isPrefixOfWord(sc.nextLine(),sc.next()));
    }
}
class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] a = sentence.split(" ");
        int n = a.length,m = searchWord.length();
        for(int i=0;i<n;i++){
            if(m<=a[i].length() && searchWord.equals(a[i].substring(0,m)))
                return i+1;
        }
        return -1;
    }
}
