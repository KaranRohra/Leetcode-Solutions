package leetCode;

import java.util.Scanner;

public class ImplementstrStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution28 s = new Solution28();
        System.out.print(s.strStr(sc.next(),sc.next()));
    }
}
class Solution28 {
    public int strStr(String haystack, String needle) {
        int n=haystack.length(),m=needle.length(),index=-1;
        String str;
        if(needle.equals("") || haystack.equals(needle))
            return 0;
        if(m>n)
            return -1;
        for(int i=0;i<=n-m;i++){
            str = haystack.substring(i,m+i);
            if(str.equals(needle)){
                index = i;
                break;
            }
        }
        return index;
    }
}