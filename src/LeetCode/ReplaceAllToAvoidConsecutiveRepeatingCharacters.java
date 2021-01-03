package leetCode;

import java.util.Scanner;

// Replace All ?'s to Avoid Consecutive Repeating Characters
public class ReplaceAllToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1576 s= new Solution1576();
        System.out.println(s.modifyString(sc.next()));
    }
}
class Solution1576 {
    public String modifyString(String s) {
        char[] str=s.toCharArray();
        int n=str.length;
        if(n==1){
            if(str[0]=='?')
                return "a";
            return s;
        }
        for(int i=0;i<n;i++){
            if(str[i]=='?') {
                if (i == 0) {
                    if (str[i + 1] != 'a')
                        str[i] = 'a';
                    else
                        str[i] = 'b';
                } else if (i == n - 1) {
                    if (str[i - 1] != 'a')
                        str[i] = 'a';
                    else
                        str[i] = 'b';
                } else {
                    char k = 'a';
                    while (k <= 'z') {
                        if (str[i + 1] != k && str[i - 1] != k)
                            break;
                        k++;
                    }
                    str[i] = k;
                }
            }
        }
        return String.valueOf(str);
    }
}
