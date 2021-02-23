package LeetCode;

import java.util.*;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1,2,3,1},3));
    }
}
//https://leetcode.com/problems/contains-duplicate-ii/
class Solution219 {// 5 ms and 3 incorrect submissions
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            Integer index=map.get(nums[i]);
            if(index!=null && Math.abs(index-i)<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}