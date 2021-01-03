package leetCode;

import java.util.Scanner;

public class IsSubsequence {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution392 s = new Solution392();
        System.out.println(s.isSubsequence(sc.next(),sc.next()));
    }
}
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        char []a=s.toCharArray();
        char []b=t.toCharArray();
        int i,j=0,n=s.length(),m=t.length(),count=0;
        for(i=0;i<n;i++){
            for(;j<m;j++){
                if(a[i]==b[j]){
                    count++;
                    break;
                }
            }
            j++;
        }
        return count == n;
    }
}