package leetCode;

import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution12 s = new Solution12();
        System.out.println(s.intToRoman(sc.nextInt()));
    }
}
class Solution12 {
    public String intToRoman(int n) {
        StringBuilder roman= new StringBuilder();
        int []a=new int[4];
        int i=3;
        while(n!=0){
         a[i]=n%10;
         n/=10;
         i--;
        }
        for(i=0;i<a[0];i++)// 1000th place
            roman.append("M");

        if(a[1]==9)   //100th place
            roman.append("CM");
        else if(a[1]==4)
            roman.append("CD");
        else {
            if(a[1]<5){
                for(i=0;i<a[1];i++)
                    roman.append("C");
            }
            else{
                roman.append("D");
                for(i=0;i<a[1]-5;i++)
                    roman.append("C");
            }
        }

        if(a[2]==9)  //10th place
            roman.append("XC");
        else if(a[2]==4)
            roman.append("XL");
        else{
            if(a[2]<5){
                for(i=0;i<a[2];i++)
                    roman.append("X");
            }
            else{
                roman.append("L");
                for(i=0;i<a[2]-5;i++)
                    roman.append("X");
            }
        }

        if(a[3]==9)   //0th place
            roman.append("IX");
        else if(a[3]==4)
            roman.append("IV");
        else{
            if(a[3]<5){
                for(i=0;i<a[3];i++)
                    roman.append("I");
            }
            else{
                roman.append("V");
                for(i=0;i<a[3]-5;i++)
                    roman.append("I");
            }
        }
        return roman.toString();
    }
}