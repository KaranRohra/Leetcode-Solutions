package LeetCode;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(new Solution917().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
//https://leetcode.com/problems/reverse-only-letters/
class Solution917 {//0 ms
    public String reverseOnlyLetters(String S) {
        char[] str=S.toCharArray();
        int i=0,j=str.length-1;
        while(i<j){
            if(str[i]>='a' && str[i]<='z' || str[i]>='A' && str[i]<='Z'){
                while(i<j){
                    if(str[j]>='a' && str[j]<='z' || str[j]>='A' && str[j]<='Z'){
                        char temp=str[i];
                        str[i]=str[j];
                        str[j]=temp;
                        j--;
                        break;
                    }else{
                        j--;
                    }
                }
            }
            i++;
        }
        return String.valueOf(str);
    }
}