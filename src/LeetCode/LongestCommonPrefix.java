package LeetCode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new Solution14().longestCommonPrefix(new String[]{
                "flower","flow","flight"
        }));
    }
}
//https://leetcode.com/problems/longest-common-prefix/
class Solution14 {// 0 ms
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length,m;

        if(n==0 || strs[0].length()==0)
            return "";
        m=strs[0].length();

        for(int i=1;i<n;i++){
            while(strs[i].indexOf(strs[0])!=0){
                strs[0]=strs[0].substring(0,m-1);
                m--;
                if(m==0)
                    return "";
            }
        }
        return strs[0];
    }
}