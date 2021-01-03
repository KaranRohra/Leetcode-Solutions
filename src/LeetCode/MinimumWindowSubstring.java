package LeetCode;

public class MinimumWindowSubstring {// VVV IMP
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC","ABC"));
        /*
        EDGE cases
          s     t
        "aaaa" , "aaa"
        "bba" , "ab"
        "a" , "a"
        "a" , "aa"
         */
    }
}
//https://leetcode.com/problems/minimum-window-substring/
class Solution76 {// 5 ms
    public String minWindow(String str, String tr) {
        String result;

        char[] s=str.toCharArray();
        char[] t=tr.toCharArray();

        int[] sCnt=new int[128];
        int[] tCnt=new int[128];

        int n=s.length;
        for(char c:t)
            tCnt[c]++;

        int i=0,j=0;
        while(i<n && tCnt[s[i]]==0){
            i++;
            j++;
        }
        if(i==n)
            return "";

        while(j<n && jCanGoForward(sCnt,tCnt)){
            sCnt[s[j]]++;
            j++;
        }
        if(j==n && jCanGoForward(sCnt,tCnt))
            return "";

        result=str.substring(i,j);
        boolean canIGoForward=false;
        while(canIGoForward || j<n){
            sCnt[s[i]]--;
            canIGoForward=iCanGoForward(sCnt,tCnt,s[i]);
            if(canIGoForward){
                i++;
                if(j-i<result.length() || result.length()==0) {
                    result = str.substring(i, j);
                }
            }
            else {
                sCnt[s[i]]++;
                sCnt[s[j]]++;
                j++;
            }
        }
        canIGoForward=iCanGoForward(sCnt,tCnt,s[i]);
        while (i<n && canIGoForward){
            sCnt[s[i]]--;
            canIGoForward=iCanGoForward(sCnt,tCnt,s[i]);
            if(canIGoForward){
                i++;
                if(j-i<result.length() || result.length()==0) {
                    result = str.substring(i, j);
                }
            }else {
                sCnt[s[i]]++;
            }
        }
        return result;
    }

    private boolean iCanGoForward(int[] sCnt, int[] tCnt,char c) {
        if(tCnt[c]!=0 && tCnt[c]>sCnt[c])
            return false;
        return true;
    }

    private boolean jCanGoForward(int[] sCnt,int[] tCnt){
        for(int i=0;i<128;i++){
            if(tCnt[i]!=0 && tCnt[i]>sCnt[i])
                return true;
        }
        return false;
    }
}
/* Older version with greater time complexity
class Solution76 {// 25 ms
    public String minWindow(String str, String tr) {
        String result="";

        char[] s=str.toCharArray();
        char[] t=tr.toCharArray();

        int[] sCnt=new int[128];
        int[] tCnt=new int[128];

        int n=s.length;
        for(char c:t)
            tCnt[c]++;

        int i=0,j=0;
        while(i<n && tCnt[s[i]]==0){
            i++;
            j++;
        }
        if(i==n)
            return "";

        while(j<n && jCanGoForward(sCnt,tCnt)){
            sCnt[s[j]]++;
            j++;
        }
        if(j==n && jCanGoForward(sCnt,tCnt))
            return "";

        result=str.substring(i,j);
        boolean canIGoForward=false;
        while(canIGoForward || j<n){
            sCnt[s[i]]--;
            canIGoForward=iCanGoForward(sCnt,tCnt);
            if(canIGoForward){
                i++;
                if(j-i<result.length() || result.length()==0) {
                    result = str.substring(i, j);
                }
            }
            else {
                sCnt[s[i]]++;
                sCnt[s[j]]++;
                j++;
            }
        }
        canIGoForward=iCanGoForward(sCnt,tCnt);
        while (i<n && canIGoForward){
            sCnt[s[i]]--;
            canIGoForward=iCanGoForward(sCnt,tCnt);
            if(canIGoForward){
                i++;
                if(j-i<result.length() || result.length()==0) {
                    result = str.substring(i, j);
                }
            }else {
                sCnt[s[i]]++;
            }
        }
        return result;
    }

    private boolean iCanGoForward(int[] sCnt, int[] tCnt) {
        for(int i=0;i<128;i++){
            if(tCnt[i]!=0 && tCnt[i]>sCnt[i])
                return false;
        }
        return true;
    }

    private boolean jCanGoForward(int[] sCnt,int[] tCnt){
        for(int i=0;i<128;i++){
            if(tCnt[i]!=0 && tCnt[i]>sCnt[i])
                return true;
        }
        return false;
    }
}
 */