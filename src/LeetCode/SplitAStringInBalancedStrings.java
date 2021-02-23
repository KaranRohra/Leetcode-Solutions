package LeetCode;

public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        System.out.println(new Solution1221().balancedStringSplit("RLRRLLRLRL"));
    }
}
//https://leetcode.com/problems/split-a-string-in-balanced-strings/
class Solution1221 { // 0 ms
    public int balancedStringSplit(String s) {
        char[] str=s.toCharArray();
        int n=str.length;
        int res=0;
        for(int i=0;i<n;i++){
            int countR=0,countL=0;
            if(str[i]=='L')
                countL++;
            else
                countR++;
            for(int j=i+1;j<n;j++){
                if(str[j]=='L')
                    countL++;
                else
                    countR++;
                if(countR==countL){
                    res++;
                    i=j;
                    break;
                }
            }
        }
        return res;
    }
}
