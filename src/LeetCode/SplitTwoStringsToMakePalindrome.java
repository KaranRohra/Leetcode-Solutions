package LeetCode;

public class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution1616().checkPalindromeFormation("ulacfd","jizalu"));
    }
}
//https://leetcode.com/problems/split-two-strings-to-make-palindrome/submissions/
class Solution1616 { // 9 ms
    public boolean checkPalindromeFormation(String a, String b) {
        char[] strA=a.toCharArray();
        char[] strB=b.toCharArray();
        int n=strA.length;

        boolean check=true;
        boolean resA=true,resB=true;
        int i=0,j=n-1;
        while(i<j){ // checking a prefix and b suffix
            if (strA[i] != strB[j] || !check) {
                check = false;
                if (strB[i] != strB[j] && resB) {
                    resB = false;
                }
                if (strA[i] != strA[j] && resA) {
                    resA = false;
                }
            }
            i++;
            j--;
        }
        if(resA || resB)
            return true;
        check=true;
        resA=resB=true;

        i=0;j=n-1;
        while(i<j){ // checking a prefix and b suffix
            if (strB[i] != strA[j] || !check) {
                check = false;
                if (strB[i] != strB[j] && resB) {
                    resB = false;
                }
                if (strA[i] != strA[j] && resA) {
                    resA = false;
                }

            }
            i++;
            j--;
        }
        return resA || resB;
    }
}