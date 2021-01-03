package LeetCode;

import java.util.Scanner;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution1160 s = new Solution1160();
        int n=sc.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++)
            words[i]=sc.next();
        String chars = sc.next();
        System.out.println(s.countCharacters(words,chars));
    }
}
class Solution1160 {
    public int countCharacters(String[] w, String c) {
        int totalL=0,count;
        int []a = new int[26];
        int []b;
        int m=c.length(),k;
        for(int i=0;i<m;i++)
            a[c.charAt(i)-'a']++;
        for (String s : w) {
            b = new int[26];
            k = s.length();
            count = 0;
            for (int j = 0; j < k; j++)
                b[s.charAt(j) - 'a']++;
            for (int j = 0; j < k; j++) {
                var x = b[s.charAt(j) - 'a'];
                var y = a[s.charAt(j) - 'a'];
                if (y == 0 || y < x)
                    break;
                else
                    count++;
            }
            if (count == k)
                totalL += k;
        }
        return totalL;
    }
}
