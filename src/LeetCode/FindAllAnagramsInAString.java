package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Solution438 s = new Solution438();
        System.out.println(s.findAnagrams(sc.next(),sc.next()));
    }
}
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> a = new ArrayList<>();
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        int[] c = new int[26];
        for (char i : str2) c[i - 'a']++;

        loop:
        for (int i = 0; i <= str1.length - str2.length; i++) {
            int[] c1 = new int[26];
            for (int j = i; j < str2.length+i; j++) c1[str1[j] - 'a']++;
            for (int j = i; j < str2.length; j++) if (c[str2[i]-'a'] != c1[str1[j]-'a']) continue loop;
            a.add(i);
        }
        return a;
    }
}