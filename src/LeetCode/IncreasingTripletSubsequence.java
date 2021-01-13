package LeetCode;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(new Solution334().increasingTriplet(
                new int[]{1,2,3,4,5}
        ));
    }
}
//https://leetcode.com/problems/increasing-triplet-subsequence/submissions/
class Solution334 {// 0 ms
    boolean result;
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE,first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        for(int i:nums){
            if(second<i)
                return true;
            if(i>first)
                second=i;
            if(i>min && i<second){
                second=i;
                first=min;
            }
            min=Math.min(min,i);
        }
        return false;
        // increasingTripletSubsequence(nums,-1,0,n,0); recursive
        // return result;
    }
    public int increasingTripletSubsequence(int[] a,int prev,int i,int n,int length){// recursive 530 ms
        if(length>=3)
            result=true;
        if(i==n || result)
            return 0;
        int ans;
        if(prev==-1 || a[prev]<a[i]){
            ans=Math.max(increasingTripletSubsequence(a,prev,i+1,n,length),
                    increasingTripletSubsequence(a,i,i+1,n,length+1)+1);
        }
        else{
            ans=increasingTripletSubsequence(a,prev,i+1,n,length);
        }
        return ans;
    }
}