package LeetCode;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public static void main(String[] args) {
        System.out.println(new Solution1347().minSteps("leetcode", "practice"));
    }
}
//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
class Solution1347 {// 8 ms
    public int minSteps(String str, String tar) {
        int[] cnt=new int[26];
        char[] s=str.toCharArray();
        char[] t=tar.toCharArray();
        int n=s.length;
        for(int i=0;i<n;i++){
            cnt[t[i]-'a']++;
            cnt[s[i]-'a']--;
        }
        int res=0;
        for(int i=0;i<26;i++){
            if(cnt[i]<0){
                res+=cnt[i];
            }
        }
        return -res;
    }
}