package LeetCode;

import java.util.Scanner;

public class ConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1446 s = new Solution1446();
        System.out.println(s.maxPower(sc.next()));
    }
}
class Solution1446 {
    public int maxPower(String s) {
        char[] str = s.toCharArray();
        int n = str.length,count,max = 1;
        for(int i=1;i<n;i++){
            count=1;
            if(str[i]==str[i-1]){
                for(;i<n;i++){
                    if(str[i]!=str[i-1])
                        break;
                    count++;
                }
                if(count>max)
                    max=count;
            }
        }
        return max;
    }
}

