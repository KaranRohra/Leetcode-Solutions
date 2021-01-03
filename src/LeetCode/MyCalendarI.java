package leetCode;

import java.util.Scanner;

public class MyCalendarI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution729 s = new Solution729();
        System.out.println(s.book(10,20));
        System.out.println(s.book(8,10));
        System.out.println(s.book(20,30));
        System.out.println(s.book(25,40));
        System.out.println(s.book(40,43));
    }
}
class Solution729 {
    int []s = new int[100001];
    int []e = new int[100001];
    static int i = 0;

    public boolean book(int start, int end) {
        if(start>end)
            return false;
        if(i!=0){
            for(int j=0;j<i;j++){
                if( end<=s[j] || start>=e[j])
                    continue;
                return false;
            }
        }
        s[i]=start;
        e[i]=end;
        i++;
        return true;
    }
}
