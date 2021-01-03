package LeetCode;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution704 s = new Solution704();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.search(a,sc.nextInt()));
    }
}
class Solution704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    public int binarySearch(int []a,int low,int high,int x){
        int mid=(low+high)/2;
        if(high>=low){
            if(a[mid]==x)
                return mid;
            else if(a[mid]>x)
                return binarySearch(a,low,mid-1,x);
            return binarySearch(a,mid+1,high,x);
        }
        return -1;
    }
}