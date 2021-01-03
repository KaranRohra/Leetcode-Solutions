package LeetCode;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution65 s = new Solution65();
        System.out.println(s.isNumber(sc.nextLine()));
    }
}
class Solution65 {
    public boolean isNumber(String s) {
        char[] str=s.toCharArray();
        int n=str.length,k=0,j=n-1;
        while (k<n && str[k]==' ')
            k++;
        while (j>=0 && str[j]==' ')
            j--;
        int e=0,p=0,number=0;
        for(int i=k;i<=j;i++){
            if(str[i]=='e'){
                if(i==k || i==j || number==0)
                    return false;
                e++;
            }
            else if(str[i]=='.') {
                if(e!=0)
                    return false;
                p++;
            }
            else if(str[i]=='+' || str[i]=='-'){
                if(i!=k && str[i-1]!='e' || i==j)
                    return false;
                else if(i==k && !(str[i+1]>='0' && str[i]<='9') && str[i+1]!='.')
                    return false;
            }
            else if(str[i]>='0' && str[i]<='9')
                number++;
            else if(str[i]<'0' || '9'<str[i])
                return false;
            if(p>1 || e>1)
                return false;
        }
        return number!=0;
    }
}
