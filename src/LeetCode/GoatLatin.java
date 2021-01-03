package LeetCode;

import java.util.Scanner;

public class GoatLatin {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution824 s = new Solution824();
        System.out.println(s.toGoatLatin(sc.nextLine()));
    }
}
class Solution824 {
    public String toGoatLatin(String s) {
        String []word = s.split(" ");
        int n = word.length;
        char []str ;
        for(int i=0;i<n;i++){
            str = word[i].toCharArray();
            if(str[0]!='a' && str[0]!='e' && str[0]!='i' && str[0]!='o' && str[0]!='u' && str[0]!='A' && str[0]!='E' && str[0]!='I' && str[0]!='O' && str[0]!='U')
                word[i]=word[i].substring(1)+word[i].substring(0,1);
            word[i]=word[i]+"ma";
            for(int j=0;j<i+1;j++)
                word[i]+="a";
            word[i]+=" ";
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<n-1;i++)
            result.append(word[i]).append(" ");
        return String.valueOf(result.append(word[n-1]));
    }
}