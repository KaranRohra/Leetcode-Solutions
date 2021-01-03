package LeetCode;

import java.util.Scanner;

public class BullsAndCows {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution299 s = new Solution299();
        System.out.println(s.getHint(sc.next(),sc.next()));
    }
}
class Solution299 {
    public String getHint(String secret, String guess) {
        int n=guess.length(),bulls=0,cows=0;
        char []s=secret.toCharArray();
        char []g=guess.toCharArray();
        for(int i=0;i<n;i++){
            if(s[i]==g[i]){
                bulls++;
                s[i]='X';
                g[i]='Y';
            }
        }
        for(int i=0;i<n;i++){
            if(g[i]>='0' && g[i]<='9'){
                for(int j=0;j<n;j++){
                    if(g[i]==s[j]){
                        cows++;
                        s[j]='X';
                        g[i]='Y';
                        break;
                    }
                }
            }
        }
        return bulls+"A"+cows+"B";
    }
}