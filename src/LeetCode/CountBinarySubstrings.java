package LeetCode;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(new Solution696().countBinarySubstrings("000111"));
    }
}
//https://leetcode.com/problems/count-binary-substrings/
class Solution696 {// 11 ms and 1 incorrect submission
    public int countBinarySubstrings(String s) {
        char[] str=s.toCharArray();
        int n=str.length,res=0;

        int i=0;
        while(i<n){
            if(str[i]=='0'){
                int[] zero=count(str,i,'0');

                int[] one=count(str,zero[1],'1');

                res+=Math.min(zero[2],one[2]);
                i=zero[1];
            }else{
                int[] one=count(str,i,'1');

                int[] zero=count(str,one[1],'0');

                res+=Math.min(zero[2],one[2]);
                i=one[1];
            }
        }
        return res;
    }
    private int[] count(char[] str,int start,char c){
        int count=0;
        int end=start;
        while(end<str.length && str[end]==c){
            end++;
            count++;
        }
        return new int[]{start,end,count};
    }
}

