package leetCode;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution485 s = new Solution485();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.findMaxConsecutiveOnes(a));
    }
}
class Solution485 {
    public int findMaxConsecutiveOnes(int[] a) {
        int n = a.length,count,max = 1;
        if(n==1 && a[0]==1)
            return 1;
        if((n==1 && a[0]==0) || (n==2 && a[0]==0 && a[1]==0))
            return 0;
        for(int i=1;i<n;i++){
            count=1;
            if(a[i]==a[i-1] && a[i]==1){
                for(;i<n;i++){
                    if(a[i]!=a[i-1])
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
