package leetCode;

import java.util.Scanner;

public class StringCompression {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution443 s = new Solution443();
        char []str=sc.next().toCharArray();
        int n=s.compress(str);
        for(int i=0;i<n;i++)
            System.out.print(str[i]);
    }
}
class Solution443{
    public int compress(char[] chars) {
        int n=chars.length,k=0,count=1,i,j;
        String str;
        if(n==1)
            return 1;
        for(i=1;i<n;i++){
            if(chars[i]==chars[i-1])
                count++;
            else {
                str=String.valueOf(count);
                chars[k++]=chars[i-1];
                if(count>1) {
                    for (j = 0; j < str.length(); j++)
                        chars[k++] = str.charAt(j);
                }
                count=1;
            }
        }
        i=n-1;
        count=1;
        while (i-1>=0 && chars[i]==chars[i-1]){
            count++;
            i--;
        }
        str=String.valueOf(count);
        chars[k++]=chars[i];
        if(count>1) {
            for (j = 0; j < str.length(); j++)
                chars[k++] = str.charAt(j);
        }
        return k;
    }
}
