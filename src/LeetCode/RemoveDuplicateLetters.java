package LeetCode;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("abcacb"));
    }
}
//https://leetcode.com/problems/remove-duplicate-letters/
class Solution316 {// 1 ms
    public String removeDuplicateLetters(String s) {
        char[] str=s.toCharArray();
        int[] cnt=new int[26];
        int[] map=new int[26];

        for(char c: str){
            cnt[c-'a']++;
        }

        int top=-1;

        for(char c:str){
            if(map[c-'a']>0){
                cnt[c-'a']--;
                continue;
            }
            while(top!=-1 && str[top]>=c && cnt[str[top]-'a']>1){
                cnt[str[top]-'a']--;
                map[str[top]-'a']--;
                top--;
            }
            top++;
            str[top]=c;
            map[c-'a']++;
        }

        return String.valueOf(str).substring(0,top+1);
    }
}

