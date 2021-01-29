package LeetCode;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new Solution763().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
//https://leetcode.com/problems/partition-labels/submissions/
class Solution763 {// 2 ms
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        char[] str=S.toCharArray();
        int n=str.length,end,start=0;

        int[] cnt=new int[26];
        for(int i=0;i<n;i++)
            cnt[str[i]-'a']=i;

        for(int i=0;i<n;i++){
            end=cnt[str[i]-'a'];
            while(i!=end){
                end=Math.max(end,cnt[str[i]-'a']);
                i++;
            }
            res.add(end-start+1);
            start=end+1;
        }
        return res;
    }
}
/*
4 ms
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        char[] str=S.toCharArray();
        int n=str.length,end=0,start=0;

        int[] cnt=new int[26];
        for(char c:str)
            cnt[c-'a']++;

        while(end<n){
            cnt[str[end]-'a']--;
            if(isPartitioned(cnt,str,start,end)){
                res.add(end-start+1);
                start=end+1;
            }
            end++;
        }
        return res;
    }
    private boolean isPartitioned(int[] cnt,char[] str,int start,int end){
        while (start<=end){
            if(cnt[str[start]-'a']!=0)
                return false;
            start++;
        }
        return true;
    }
}

 */

