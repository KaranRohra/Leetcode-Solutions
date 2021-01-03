package leetCode;

import java.util.Scanner;

public class NthDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution400 s = new Solution400();
        System.out.println(s.findNthDigit(sc.nextInt()));
    }
}
class Solution400 {
    public int findNthDigit(int n) {
        int i=0,count=0,m=0,k;
        while(n>0){
            count=n;
            m+=9*Math.pow(10,i-1);
            n-=9*Math.pow(10,i)*(i+1);
            i++;
        }
        k=count%i;
        count/=i;
        count+=m;
        if(k==0)
            return count%10;
        else{
            count++;
            return String.valueOf(count).charAt(k-1)-'0';
        }
    }
}