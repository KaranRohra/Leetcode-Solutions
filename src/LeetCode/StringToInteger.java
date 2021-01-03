package leetCode;

import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution8 s = new Solution8();
        System.out.println(s.myAtoi(sc.nextLine()));
    }
}
class Solution8 {
    public int myAtoi(String s) {
        char[] str = s.trim().toCharArray();
        char[] n = new char[1000];
        int m=str.length,i=0,x,k=0;
        boolean sign=false;
        if(i<m && str[i]=='-') {
            sign = true;
            i++;
        }
        else if(i<m && str[i]=='+')
            i++;
        while(i<m && str[i]=='0')
            i++;
        x=i;
        while(i<m && str[i]>='0' && str[i]<='9')
            i++;
        if(x==i)
            return 0;
        for(int j=x;j<i;j++)
            n[k++]=str[j];
        try {
            int i1 = Integer.parseInt(String.valueOf(n).substring(0, k));
            if(sign)
                return -i1;
            else
                return i1;
        }
        catch (Exception e){
            if(sign)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
    }
}