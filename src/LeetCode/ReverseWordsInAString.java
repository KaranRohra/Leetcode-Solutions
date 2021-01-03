package leetCode;

import java.util.Scanner;

public class ReverseWordsInAString {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution151 s = new Solution151();
        String str=sc.nextLine();
        System.out.println(s.reverseWords(str));
    }
}
class Solution151{
    public String reverseWords(String s) {
        int n=s.length();
        char []str=s.toCharArray();
        int a=0,b=n-1;
        while(a<n && str[a]==' ')
            a++;
        while( b>=0 && str[b]==' ')
            b--;
        int k=0;
        for(int i=a;i<=b;i++){
            if(str[i]!=' '){
                str[k++]=str[i];
            }
            else if(str[i+1]!=' '){
                str[k++]=str[i];
            }
        }
        char []result=new char[k];
        int temp=k-1,x=0;
        for(int i=k-1;i>=0;i--){
            if(str[i]==' '){
                for(int j=i+1;j<=temp;j++)
                    result[x++]=str[j];
                result[x++]=' ';
                temp=i-1;
            }
        }
        StringBuilder z = new StringBuilder();
        if(k==x)
            return String.valueOf(z.append(result));
        int i=0;
        while(i<k && str[i]!=' ')
            result[x++]=str[i++];
        return String.valueOf(z.append(result));
    }
}

