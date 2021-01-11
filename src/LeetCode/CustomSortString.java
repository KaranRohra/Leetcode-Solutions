package LeetCode;

public class CustomSortString {
    public static void main(String[] args) {
        System.out.println(new Solution791().customSortString("cba","abcd"));
    }
}
//https://leetcode.com/problems/custom-sort-string/
class Solution791 {// 0 ms
    public String customSortString(String S, String T) {
        int[] cnt=new int[26];
        char[] ans=T.toCharArray();
        for(char c:ans)
            cnt[c-'a']++;
        char[] str=S.toCharArray();
        int n=str.length,k=0;
        for (char c : str) {
            while (cnt[c - 'a']-- > 0) {
                ans[k++] = c;
            }
        }
        for(int i=0;i<26;i++){
            while(cnt[i]-->0){
                ans[k++]=(char)(i+'a');
            }
        }
        return new String(ans);
    }
}

