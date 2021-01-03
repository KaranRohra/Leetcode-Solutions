package LeetCode;

import java.util.Scanner;

public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1566 s = new Solution1566();
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.containsPattern(a,sc.nextInt(),sc.nextInt()));
    }
}
class Solution1566 {
    public boolean containsPattern(int[] a, int m, int k) {
        int n=a.length;
        for(int i=0;i<=n-m;i++){
            int count=1;
            for(int j=m+i;j<=n-m;j+=m) {
                if(compare(a,i,j,m+i))
                    count++;
                else
                    break;
                if(count==k)
                    return true;
            }
        }
        return false;
    }
    public boolean compare(int[] a,int s1,int s2,int e){
        for(int i=s1,j=s2;i<e;i++,j++){
            if(a[i]!=a[j])
                return false;
        }
        return true;
    }
}