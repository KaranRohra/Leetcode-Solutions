package leetCode;

import java.util.Scanner;

public class RansomNote {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution383 s = new Solution383();
        System.out.println(s.canConstruct(sc.next(),sc.next()));
    }
}
class Solution383 {
    public boolean canConstruct(String r, String m) {
        int []a=new int[26];
        if(r.length()>m.length())
            return false;
        for(int i=0;i<m.length();i++)
            a[m.charAt(i)-'a']++;
        for(int i=0;i<r.length();i++){
            var c = a[r.charAt(i) - 'a']--;
            if(c <0)
                return false;
        }
        return true;
    }
}
