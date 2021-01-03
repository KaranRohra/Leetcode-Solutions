package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class SetMismatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution645 s = new Solution645();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(Arrays.toString(s.findErrorNums(a)));
    }
}
class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length,sum=0,sum1=0,x;
        int[] a = new int[2];
        int[] c = new int[n+1];
        for(int i=0;i<n;i++){
            x = nums[i];
            c[x]++;
            if(c[x]==2){
                a[0]=x;
                nums[i]=0;
                //break;
            }
            sum1+=nums[i];
            sum+=i+1;
        }
        // for(int i=1;i<=n;i++){
        //     if(c[i]==0) {
        //         a[1] = i;
        //         break;
        //     }
        // }
        a[1]=sum-sum1;
        return a;
    }
}