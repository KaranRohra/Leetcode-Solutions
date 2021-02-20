package LeetCode;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Solution78().subsets(new int[]{1,2,3}));
    }
}
//https://leetcode.com/problems/subsets/
class Solution78 {// 0 ms and 0 incorrect submission
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            subsets(res,new int[i],nums,0,0);
        }
        return res;
    }
    private void subsets(List<List<Integer>> res,int[] a,int[] nums,int start,int curr){
        if(curr>=a.length){
            List<Integer> temp=new ArrayList<>();
            for(int i:a){
                temp.add(i);
            }
            res.add(temp);
            return;
        }

        for(int i=start;i<nums.length;i++){
            a[curr]=nums[i];
            subsets(res,a,nums,i+1,curr+1);
        }
    }
}