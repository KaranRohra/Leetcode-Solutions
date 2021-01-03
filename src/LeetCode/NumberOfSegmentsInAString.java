package leetCode;

import java.util.Scanner;

public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution434 s = new Solution434();
        System.out.println(s.countSegments(sc.nextLine()));
    }
}
class Solution434 {
    public int countSegments(String s) {
        s=s.trim();
        if(s.equals(""))
            return 0;
        char[] str = s.toCharArray();
        int count=1,n=str.length;
        for(int i=0;i<n-1;i++){
            if(str[i]==' ' && str[i+1]!=' ')
                count++;
        }
        return count;
    }
}