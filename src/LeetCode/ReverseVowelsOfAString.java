package leetCode;

import java.util.Scanner;

public class ReverseVowelsOfAString {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution345 s = new Solution345();
        System.out.println(s.reverseVowels(sc.next()));
    }
}
class Solution345 {
    public String reverseVowels(String s) {
        int n=s.length(),k=0;
        char []str=s.toCharArray();
        char []v=new char[n];
        for(char i: str){
            if(i=='a' || i=='e' || i=='i' || i=='o' || i=='u' || i=='A' || i=='E' || i=='I' || i=='O' || i=='U')
                v[k++]=i;
        }
        for(int i=0;i<n;i++){
            if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u' || str[i]=='A' || str[i]=='E' || str[i]=='I' || str[i]=='O' || str[i]=='U')
                str[i]=v[--k];
        }
        return new String(str);
    }
}