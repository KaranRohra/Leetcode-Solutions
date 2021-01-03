package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReformatDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1507 s = new Solution1507();
        System.out.println(s.reformatDate(sc.nextLine()));
    }
}
class Solution1507 {
    public String reformatDate(String d) {
        StringBuilder r = new StringBuilder();
        String []date = d.split(" ");
        List<String> month = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        int i=month.indexOf(date[1]);
        r.append(date[2]+"-");
        if((i+1)<=9)
            r.append("0");
        r.append((i+1)+"-");
        if(d.charAt(1)<='0' && d.charAt(1)<='9')
            r.append(d.charAt(0)+""+d.charAt(1));
        else
            r.append("0"+d.charAt(0));
        return new String(r);
    }
}