package LeetCode;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("abcabcabcabc"));
    }
}
//https://leetcode.com/problems/repeated-substring-pattern/
class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        outer:
        for(int i=1;i<=n;i++){
            String temp=s.substring(0,i);
            int m=temp.length();
            boolean isGone=false;
            if(n%m!=0)
                continue;
            for(int j=i;j<=n-m;j+=m){
                if(!temp.equals(s.substring(j,j+m)))
                    continue outer;
                isGone=true;
            }
            if(isGone)
                return true;
        }
        return false;
    }
}

