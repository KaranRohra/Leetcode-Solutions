package LeetCode;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(new Solution767().reorganizeString("geeksforgeeks"));
    }
}
//https://leetcode.com/problems/reorganize-string/
class Solution767 {// 0 ms
    public String reorganizeString(String S) {
        int[] cnt=new int[26];
        int n=S.length();
        char[] ans=S.toCharArray();
        for(char c: ans){
            cnt[c-'a']++;
            if(n%2==0 && cnt[c-'a']>n/2)
                return "";
            if(n%2!=0 && cnt[c-'a']>n/2+1)
                return "";
        }
        for(int i=0;i<n;){
            int max=0;
            for(int j=0;j<26;j++){
                if(cnt[j]>cnt[max])
                    max=j;
            }
            while(i<n && cnt[max]-->0){
                ans[i]=(char)('a'+max);
                i+=2;
            }
        }
        int k=1;
        for(int i=0;i<26;i++){
            while(cnt[i]-->0){
                ans[k]=(char)('a'+i);
                k+=2;
            }
        }
        return new String(ans);
    }
}