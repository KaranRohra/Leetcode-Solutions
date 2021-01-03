package LeetCode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
    }
}
class Solution3 {// 1ms
    public int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
        int[] count=new int[128];
        int n=str.length,length,max=0;

        if(n<=1)
            return n;

        int i=0,j=0;
        count[str[0]]++;

        while(j!=n-1){
            if(j<n-1 && count[str[j+1]]==0){
                j++;
                count[str[j]]++;
            }
            else{
                count[str[i]]--;
                i++;
            }
            length=j-i+1;
            if(length>max)
                max=length;
        }
        return max;
    }
}