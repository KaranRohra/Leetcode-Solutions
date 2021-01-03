package leetCode;

import java.util.Scanner;

public class ReverseStringII {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution541 s = new Solution541();
        System.out.print(s.reverseStr(sc.next(),sc.nextInt()));
    }
}
class Solution541 {
    public String reverseStr(String s, int k) {
        char []str=s.toCharArray();
        int n=s.length(),i=0,j=Math.min(k,n);
        while(i<n){
            reverse(str,i,j);
            i=j+k;
            j=Math.min(i+k,n);
        }
        return String.valueOf(str);
    }
    public void reverse(char []str,int start,int end){
        char temp;
        for(int i=start,j=end-1;i<j;i++,j--){
            temp=str[i];
            str[i]=str[j];
            str[j]=temp;
        }
    }
}