package LeetCode;

import java.util.Scanner;

public class GenerateAStringWithCharactersThatHaveOddCounts {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution1374 s = new Solution1374();
        System.out.println(s.generateTheString(sc.nextInt()));
    }
}
class Solution1374 {
    public String generateTheString(int n) {
        char []str = new char[n];
        for(int i=0;i<n;i++)
            str[i]='a';
        if(n%2 == 0)
            str[n-1]='b';
        return new String(str);
    }
}

