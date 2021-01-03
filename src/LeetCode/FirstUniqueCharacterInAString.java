package LeetCode;

import java.util.Scanner;

public class FirstUniqueCharacterInAString {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        Solution387 s = new Solution387();
        System.out.println(s.firstUniqChar(sc.next()));
    }
}
class Solution387 {
    public int firstUniqChar(String s) {
        int []a=new int[26];
        for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++){
            if(a[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
/*class Solution387 {
    public int firstUniqChar(String s) {
        char []str=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(search(str,str[i]))
                return i;
        }
        return -1;
    }
    public boolean search(char []str,char x){
        int count=0;
        for(int i=0;i<str.length;i++)
            if(str[i]==x){
                count++;
                if(count>1)
                    return false;
            }
        return true;
    }
}*/