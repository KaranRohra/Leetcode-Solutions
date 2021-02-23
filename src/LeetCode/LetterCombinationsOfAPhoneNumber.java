package LeetCode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("23"));
    }
}
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
class Solution17 {// 0 ms
    private final String[] phoneNumbers;
    Solution17(){
        phoneNumbers=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();

        setLetterCombinations(res,new char[digits.length()],0,digits);

        return res;
    }
    // Note: str.length and digits.length() both are same
    private void setLetterCombinations(List<String> res,char[] str,int curr,String digits){
        if(curr>=digits.length()){
            if(str.length!=0)
                res.add(new String(str));
            return;
        }
        int currDigit=digits.charAt(curr)-'0';
        int n=phoneNumbers[currDigit].length();
        for(int i=0;i<n;i++){
            str[curr]=phoneNumbers[currDigit].charAt(i);
            setLetterCombinations(res,str,curr+1,digits);
        }
    }
}



