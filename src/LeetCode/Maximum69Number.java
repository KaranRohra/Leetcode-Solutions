package leetCode;

import java.util.Scanner;

public class Maximum69Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1323 s = new Solution1323();
        System.out.println(s.maximum69Number(sc.nextInt()));
    }
}
class Solution1323 {
    public int maximum69Number (int num) {
        int i=0;
        char[] str = String.valueOf(num).toCharArray();
        while(i<str.length && str[i]!='6')
            i++;
        if(i<str.length)
            str[i]='9';
        return Integer.parseInt(String.valueOf(str));
    }
}
