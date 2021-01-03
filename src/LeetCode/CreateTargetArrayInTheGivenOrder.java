package LeetCode;

import java.util.*;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1389 s = new Solution1389();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
        System.out.println(Arrays.toString(s.createTargetArray(a, b)));
    }
}
class Solution1389 {// 0 ms
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> a = new ArrayList<>();
        int n=nums.length;
        int[] t=new int[n];
        for(int i=0;i<n;i++)
            a.add(index[i],nums[i]);
        for(int i=0;i<n;i++)
            t[i]=a.get(i);
        return t;
    }
}
//class Solution {// 1ms
//    public int[] createTargetArray(int[] nums, int[] index) {
//        int n=nums.length;
//        int[] t=new int[n];
//        Arrays.fill(t,-1);
//        for(int i=0;i<n;i++){
//            if(t[index[i]]==-1)
//                t[index[i]]=nums[i];
//            else{
//                shift(t,n,index[i]);
//                t[index[i]]=nums[i];
//            }
//        }
//        return t;
//    }
//    public void shift(int[] a,int n,int s){
//        for(int i=n-2;i>=s;i--){
//            a[i+1]=a[i];
//        }
//    }
//}