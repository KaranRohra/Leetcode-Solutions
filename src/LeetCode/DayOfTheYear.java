package LeetCode;

import java.util.Scanner;

public class DayOfTheYear {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution1154 s=new Solution1154();
        System.out.println(s.dayOfYear(sc.next()));
    }
}
class Solution1154 {
    int []months={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int dayOfYear(String date) {
        int yy=Integer.parseInt(date.substring(0,4));
        int mm=Integer.parseInt(date.substring(5,7));
        int dd=Integer.parseInt(date.substring(8));
        int days=0;
        if(mm>2 &&yy%400==0 || (yy%4==0 && yy%100!=0))
            days++;
        for(int i=1;i<mm;i++)
            days+=months[i];
        days+=dd;
        return days;
    }
}
