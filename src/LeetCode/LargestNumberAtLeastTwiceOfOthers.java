package leetCode;

import java.util.Scanner;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution747 s = new Solution747();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.print(s.dominantIndex(a));
;    }
}
class Solution747 {
    public int dominantIndex(int[] nums) {
        int n=nums.length,max=nums[0],i,index=0;
        for(i=0;i<n;i++)
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        for(i=0;i<n;i++){
            if(nums[i]*2>max && nums[i]!=max)
                return -1;
        }
        return index;
    }
}