package leetCode;

import java.util.Scanner;

public class RearrangeSpacesBetweenWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1592 s = new Solution1592();
        System.out.println(s.reorderSpaces(sc.nextLine()));
    }
}
class Solution1592 {
    public String reorderSpaces(String text) {
        char[] str = text.toCharArray();
        int n = str.length, space = 0, word = 0, k = 0,nSpace;
        boolean check = true;
        for (char c : str) {
            if (c == ' ') {
                space++;
                check = true;
            } else if (c >= 'a' && c <= 'z' && check) {
                word++;
                check = false;
            }
        }
        str=text.trim().toCharArray();
        char[] result=new char[n];
        if(word==1){
            System.arraycopy(str,0,result,0,str.length);
            k=str.length;
            for(int i=0;i<space;i++){
                result[k++]=' ';
            }
            return String.valueOf(result);
        }
        nSpace=space/(word-1);
        n=str.length;
        for(int i=0;i<n;){
            if(str[i]>='a' && str[i]<='z')
                result[k++]=str[i++];
            else{
                while (str[i]==' ')
                    i++;
                for(int j=0;j<nSpace;j++)
                    result[k++]=' ';
            }
        }
        while(k<result.length)
            result[k++]=' ';
        return String.valueOf(result);
    }
}