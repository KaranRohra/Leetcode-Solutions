package LeetCode;

public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(new Solution925().isLongPressedName("saeed",  "ssaaedd"));
    }
}
//https://leetcode.com/problems/long-pressed-name/
class Solution925 {// 0 ms
    public boolean isLongPressedName(String name, String typed) {
        char[] original=name.toCharArray();
        char[] type=typed.toCharArray();

        int n=original.length,m=type.length;
        int i=0,j=0;
        while(i<n){
            char c=original[i];
            int count=0;
            while(i<n && original[i]==c){
                i++;
                count--;
            }
            while(j<m && type[j]==c){
                j++;
                count++;
            }
            if(count<0)
                return false;
        }
        char c=type[n-1];
        while(j<m && type[j]==c){
            j++;
        }
        if(j!=m)
            return false;
        return true;
    }
}