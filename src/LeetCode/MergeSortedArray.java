package leetCode;

import java.util.Scanner;

public class MergeSortedArray {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution88 s = new Solution88();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []a=new int[m+n];
        int []b=new int[n];
        for(int i=0;i<m;i++){
            a[i]=sc.nextInt();
        }
        for(int j=0;j<n;j++){
            b[j]=sc.nextInt();
        }
        s.merge(a,m,b,n);
        for(int i:a)
            System.out.print(i+" ");
    }
}
class Solution88{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i,j,temp;
        for(i=m,j=0;i<m+n;i++)
            nums1[i]=nums2[j++];
        n=m+n;
        for(i=0;i<n-1;i++){
            for(j=0;j<n-i-1;j++){
                if(nums1[j]>nums1[j+1]){
                    temp=nums1[j];
                    nums1[j]=nums1[j+1];
                    nums1[j+1]=temp;
                }
            }
        }
    }
}
