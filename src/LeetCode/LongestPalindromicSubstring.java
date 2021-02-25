package LeetCode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("babad"));
    }
}
//https://leetcode.com/problems/longest-palindromic-substring/
class Solution5 {// 182 ms and 1 incorrect submission
    private Boolean[][] dp;
    public String longestPalindrome(String s) {
        int n=s.length(),max=0;
        dp=new Boolean[n+1][n+1];
        String res="";

        char[] str=s.toCharArray();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(j-i+1>max && longestPalindrome(str,j,i)){
                    max=j-i+1;
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
    public boolean longestPalindrome(char[] str,int n,int m){
        if(m>=n){
            return dp[n][m]=true;
        }
        if(dp[n][m]!=null)
            return dp[n][m];

        if(str[n]==str[m]){
            return dp[n][m]=longestPalindrome(str,n-1,m+1);
        }
        else{
            return false;
        }
    }
}
