package LeetCode;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(new Solution1768().mergeAlternately("abc","pqr"));
    }
}
//https://leetcode.com/problems/merge-strings-alternately/
class Solution1768 {// 0 ms and 0 incorrect submission
    public String mergeAlternately(String word1, String word2) {
        char[] a=word1.toCharArray();
        char[] b=word2.toCharArray();
        int n=a.length,m=b.length;
        char[] res=new char[n+m];
        int i=0,j=0,k=0;
        while(i<n&&j<m){
            res[k++]=a[i++];
            res[k++]=b[j++];
        }
        while(i<n){
            res[k++]=a[i++];
        }
        while(j<m){
            res[k++]=b[j++];
        }
        return new String(res);
    }
}