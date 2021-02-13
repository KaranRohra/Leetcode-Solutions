package LeetCode;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2,3,5},8));
    }
}
//https://leetcode.com/problems/combination-sum/submissions/
class Solution39 {// 2 ms
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=unboundedKnapsack(candidates,target,candidates.length-1);
        return res==null?new ArrayList<>():res;
    }
    private List<List<Integer>> unboundedKnapsack(int[] candidates,int sum,int curr){

        if(sum==0){
            List<List<Integer>> res=new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        if(curr==-1){
            return null;
        }

        if(sum-candidates[curr]>=0){

            List<List<Integer>> ans1 = unboundedKnapsack(candidates,sum-candidates[curr],curr);
            List<List<Integer>> ans2 = unboundedKnapsack(candidates,sum,curr-1);

            if(ans1!=null){
                for (List<Integer> integers : ans1) {
                    integers.add(candidates[curr]);
                }
                if(ans2!=null)
                    ans1.addAll(ans2);
                return ans1;
            }
            return ans2;

        }else{
            return unboundedKnapsack(candidates,sum,curr-1);
        }
    }
}