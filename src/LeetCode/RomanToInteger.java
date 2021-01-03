package leetCode;

import java.util.Scanner;

public class RomanToInteger {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        Solution13 s = new Solution13();
        System.out.println(s.romanToInt(sc.next()));
    }
}
class Solution13 {
    public int romanToInt(String s) {
        int []decimal=new int[4];
        int n=s.length();
        char []roman=s.toCharArray();
        int k=0;

        while(n>k && roman[k]=='M'){// 1000TH PLACE
            decimal[0]=1+k++;
        }

        if(n>=k+1) {// 100TH PLACE
            if (roman[k] == 'C' && n>=k+2 && roman[k + 1] == 'D') {
                decimal[1] = 4;
                k+=2;
            }
            else if (roman[k] == 'C' && n>=k+2 && roman[k + 1] == 'M') {
                decimal[1] = 9;
                k += 2;
            }
            else if (roman[k] == 'C') {
                decimal[1] = 1;
                k++;
            }
            else if (roman[k] == 'D') {
                decimal[1] = 5;
                k++;
            }
            if(decimal[1]==5 || decimal[1]==1) {
                while (n > k && roman[k] == 'C') {
                    decimal[1]++;
                    k++;
                }
            }
        }

        if(n>=k+1) {//10TH PLACE
            if (roman[k] == 'X' && n>=k+2 && roman[k + 1] == 'L') {
                decimal[2] = 4;
                k+=2;
            }
            else if (roman[k] == 'X' && n>=k+2 && roman[k + 1] == 'C') {
                decimal[2] = 9;
                k += 2;
            }
            else if (roman[k] == 'X') {
                decimal[2] = 1;
                k++;
            }
            else if (roman[k] == 'L') {
                decimal[2] = 5;
                k++;
            }
            if(decimal[2]==5 || decimal[2]==1) {
                while (n > k && roman[k] == 'X') {
                    decimal[2]++;
                    k++;
                }
            }
        }
        if(n>=k+1) {// 0TH PLACE
            if (roman[k] == 'I' && n>=k+2 && roman[k + 1] == 'V') {
                decimal[3] = 4;
                k+=2;
            }
            else if (roman[k] == 'I' && n>=k+2 && roman[k + 1] == 'X') {
                decimal[3] = 9;
                k += 2;
            }
            else if (roman[k] == 'I') {
                decimal[3] = 1;
                k++;
            }
            else if (roman[k] == 'V') {
                decimal[3] = 5;
                k++;
            }
            if(decimal[3]==5 || decimal[3]==1) {
                while (n > k && roman[k] == 'I') {
                    decimal[3]++;
                    k++;
                }
            }
        }
        return decimal[0]*1000+decimal[1]*100+decimal[2]*10+decimal[3];
    }
}
