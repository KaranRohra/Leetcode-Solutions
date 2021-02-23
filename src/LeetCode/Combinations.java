package LeetCode;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4,2));
    }
}
//https://leetcode.com/problems/combinations/
class Solution77 {// 6 ms
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        combine(res,new int[k],n,k,1);
        return res;
    }
    private void combine(List<List<Integer>> res,int[] nums,int n,int k,int curr){
        if(k==0){
            List<Integer> temp=new ArrayList<>();
            for(int i=nums.length-1;i>=0;i--){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        for(int i=curr;i<=n;i++){
            nums[k-1]=i;
            combine(res,nums,n,k-1,i+1);
        }
    }
}
