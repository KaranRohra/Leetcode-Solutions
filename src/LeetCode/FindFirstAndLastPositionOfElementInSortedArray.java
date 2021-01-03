package LeetCode;

import java.util.Scanner;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public  static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution34 s = new Solution34();
        int n=sc.nextInt();
        int []a=new int[n];
        int i=0;
        while(i<n)
            a[i++]=sc.nextInt();
        int t=sc.nextInt();
        int []result=s.searchRange(a,t);
        System.out.println(result[0]+" "+result[1]);
    }
}
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int []s={-1,-1};
        int n=nums.length;
        loop1: for(int i=0;i<n;i++){
            if(nums[i]==target){
                s[0]=i;
                for(int j=i;j<n;j++){
                    if(nums[j]!=nums[i]){
                        s[1]=j-1;
                        break loop1;
                    }
                }
                s[1]=n-1;
                break;
            }
        }
        return s;
    }
}