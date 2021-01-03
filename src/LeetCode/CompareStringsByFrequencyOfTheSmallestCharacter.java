package LeetCode;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1170().numSmallerByFrequency(
                new String[]{"bbb","cc"},
                new String[]{"a","aa","aaa","aaaa"}
                )));
    }
}
//https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
class Solution1170 {// 24 ms
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n=queries.length,m=words.length;

        int[] qCnt=fillTheCount(queries);
        int[] wCnt=fillTheCount(words);

        int[] result=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(qCnt[i]<wCnt[j])
                    result[i]++;
            }
        }
        return result;
    }
    private int[] fillTheCount(String[] str){
        int n=str.length;
        int[] resultCnt=new int[n];
        for(int i=0;i<n;i++){
            int[] cnt=new int[26];

            int m=str[i].length();
            char minChar='z';
            for(int j=0;j<m;j++){
                char c=str[i].charAt(j);
                cnt[c-'a']++;
                if(c<minChar)
                    minChar=c;
            }
            resultCnt[i]=cnt[minChar-'a'];
        }
        return resultCnt;
    }
}