package leetCode;

import java.util.Scanner;

public class RepeatedStringMatch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution686 s = new Solution686();
        System.out.println(s.repeatedStringMatch(sc.next(),sc.next()));
    }
}
class Solution686 {
    public int repeatedStringMatch(String A, String B) {
        int n=A.length(),m=B.length(),i,j,count,k;
        boolean p;
        for(i=0;i<n;i++){
            p = true;
            count=1;
            if(B.charAt(0)==A.charAt(i)){
                k=i;
                for(j=0;j<m;j++,k++){
                    if(A.charAt(k%n) != B.charAt(j)) {
                        p = false;
                        break;
                    }
                    if(k!=0 && k%n == 0)
                        count++;
                }
                if(p)
                    return count;
            }
        }
        return -1;
    }
}
