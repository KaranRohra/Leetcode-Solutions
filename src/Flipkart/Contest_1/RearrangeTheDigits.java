package Flipkart.Contest_1;

import java.util.Scanner;

public class RearrangeTheDigits {
    public static void main(String[] args) {
        System.out.println(new Solution_1().smallestnum(new Scanner(System.in).next()));
    }
}
class Solution_1
{
    public String smallestnum(String N)
    {
        char[] str=N.toCharArray();
        int k=0;
        int[] cnt=new int[10];
        for (char c : str) {
            cnt[c - '0']++;
        }
        for(int i=1;i<10;i++){
            if(cnt[i]!=0){
                str[k++]=String.valueOf(i).charAt(0);
                cnt[i]--;
                break;
            }
        }
        for(int i=0;i<10;i++){
            while(cnt[i]-->0){
                str[k++]=String.valueOf(i).charAt(0);
            }
        }
        return String.valueOf(str);
    }
}

