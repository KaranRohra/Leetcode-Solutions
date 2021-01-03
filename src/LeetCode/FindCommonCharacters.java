package LeetCode;

import java.util.*;

public class FindCommonCharacters {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        Solution1002 s = new Solution1002();
        int n =sc.nextInt();
        String []a =new String[n];
        for(int i=0;i<n;i++)
            a[i]=sc.next();
        System.out.println(s.commonChars(a));
    }
}
class Solution1002 {
    public List<String> commonChars(String[] str) {
        List<String> a = new ArrayList<>();
        int n = str.length;
        int [][]cnt = new int[n][26];
        for(int i=0;i<n;i++){
            for(int j=0;j<str[i].length();j++){
                cnt[i][str[i].charAt(j)-'a']++;
            }
        }
        boolean flag;
        for(int i=0;i<26;i++){
            flag=true;
            for(int j=0;j<n;j++){
                if (cnt[j][i] < 1) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                a.add((char)(i+'a')+"");
                for(int j=0;j<n;j++)
                    cnt[j][i]--;
                i--;
            }
        }
        return a;
    }
}
