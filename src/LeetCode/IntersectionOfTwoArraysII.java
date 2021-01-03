package leetCode;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution350 s = new Solution350();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();

        int m = sc.nextInt();
        int[] b =  new int[m];
        for(int i=0;i<m;i++)
            b[i]=sc.nextInt();
        System.out.println(Arrays.toString(s.intersect(a, b)));
    }
}
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length,count,j=0;
        Set<Integer> s = new HashSet<>();
        ArrayList<Integer> p = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i : nums1) {
            if(search(nums2,0,m-1,i)!=-1)
                s.add(i);
        }
        for(int i : s){
            count=Math.min(count(nums1,n,i),count(nums2,m,i));
            while(count-->0)
                p.add(i);
        }
        j=0;
        int[] result= new int[p.size()];
        for(int i : p)
            result[j++]=i;
        return result;
    }
    public int search(int[] a,int low,int high,int x){
        int mid = (high+low)/2;
        if(high >= low){
            if(a[mid]==x)
                return mid;
            else if(a[mid]>x)
                return search(a,low,mid-1,x);
            return search(a,mid+1,high,x);
        }
        return -1;
    }
    public int count(int[] a,int n,int x){
        int count=0;
        for(int i=0;i<n;i++){
            if(x==a[i]){
                count++;
                if(i!=n-1 && x!=a[i+1])
                    break;
            }
        }
        return count;
    }
}