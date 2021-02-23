package LeetCode;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1,2,3}));
    }
}
//https://leetcode.com/problems/permutations/submissions/
class Solution46 {// 0 ms
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        permute(res,nums,new int[nums.length],0);
        return res;
    }
    private void permute(List<List<Integer>> res,int[] given,int[] nums,int curr){
        if(curr==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            res.add(temp);
            return;
        }

        int n=nums.length;
        for(int i=0;i<n;i++){
            if(given[i]!=11){
                nums[curr]=given[i];

                given[i]=11;
                permute(res,given,nums,curr+1);
                given[i]=nums[curr];
            }
        }
    }
}