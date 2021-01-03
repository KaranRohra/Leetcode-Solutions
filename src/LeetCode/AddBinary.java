package LeetCode;

import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution67 s = new Solution67();
        System.out.println(s.addBinary(sc.next(), sc.next()));
    }
}
class Solution67 {
    public String addBinary(String a, String b) {
        char[] str1=a.toCharArray();
        char[] str2=b.toCharArray();
        char[] str=new char[Math.max(str1.length, str2.length)+1];
        int n=str1.length,m=str2.length,i,j,k=str.length-1;
        char carry='0';
        str[0]='1';
        for(i=n-1,j=m-1;i>=0 && j>=0;i--,j--){
            if(str1[i]=='1' && str2[j]=='1' && carry=='1')
                str[k--]='1';
            else if((str1[i]=='1' && str2[j]=='1') ||(str1[i]=='1' && carry=='1') || (str2[j]=='1' && carry=='1')){
                str[k--]='0';
                carry='1';
            }
            else if(str1[i]=='1' || str2[j]=='1' || carry=='1') {
                str[k--] = '1';
                carry='0';
            }
            else
                str[k--]='0';
        }
        for(;i>=0;i--){
            if(carry=='1' && str1[i]=='1')
                str[k--]='0';
            else
                str[k--]='1';
        }
        for(;j>=0;j--){
            if(carry=='1' && str2[j]=='1')
                str[k--]='0';
            else
                str[k--]='1';
        }
        if(carry=='1')
            return String.valueOf(str);
        return String.valueOf(str).substring(1);
    }
}