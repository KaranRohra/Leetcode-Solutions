package leetCode;

import java.util.Scanner;

public class RotatedDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution788 s = new Solution788();
        System.out.println(s.rotatedDigits(sc.nextInt()));
    }
}
class Solution788 {
    public int rotatedDigits(int n) {
        int count=0,m,p1,p2;
        boolean r1,r2;
        for(int i=2;i<=n;i++){
            r1 = false;
            r2 = false;
            p1 = 0;
            p2 = 0;
            m = i;
            while(m!=0){
                if(rotated(m%10)){
                    r1=true;
                    p1++;
                }
                else if(rotatedSame(m%10)){
                    r2 = true;
                    p1++;
                }
                p2++;
                m/=10;
            }
            if(p1==p2 && r1 && r2)
                count++;
            else if(p1==p2 && r1)
                count++;
        }
        return count;
    }
    public boolean rotated(int n){
        return n==2 || n==5 || n==6 || n==9;
    }
    public boolean rotatedSame(int n){
        return n==1 || n==0 || n==8;
    }
}