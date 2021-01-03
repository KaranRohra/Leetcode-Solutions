package LeetCode;

import java.util.Scanner;

public class AddStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution415 s = new Solution415();
        System.out.println(s.addStrings(sc.next(),sc.next()));
    }
}
class Solution415 {
    public String addStrings(String num1, String num2){
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        char[] c = new char[Math.max(a.length,b.length)+1];
        char carry='0';
        int x,i,j,n=a.length,m=b.length,k=c.length-1,y,z;
        for(i=n-1,j=m-1;i>=0 && j>=0;i--,j--){
            x=carry+a[i]+b[j]-3*'0';
            y=x%10;
            z=x/10;
            carry=(char)(z+'0');
            c[k--]=(char)(y+'0');
        }
        for(;i>=0;i--){
            x=carry+a[i]-2*'0';
            y=x%10;
            z=x/10;
            carry=(char)(z+'0');
            c[k--]=(char)(y+'0');
        }
        for(;j>=0;j--){
            x=carry+b[j]-2*'0';
            y=x%10;
            z=x/10;
            carry=(char)(z+'0');
            c[k--]=(char)(y+'0');
        }
        if(carry!='0'){
            c[0]=carry;
            return String.valueOf(c);
        }
        return String.valueOf(c).substring(1);
    }
}