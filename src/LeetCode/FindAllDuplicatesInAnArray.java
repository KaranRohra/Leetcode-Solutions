package LeetCode;

import java.util.*;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        System.out.println(new Solution442().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
class Solution442 {// 5 ms
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0)
                list.add(index+1);
            else
                nums[index]=-nums[index];
        }
        return list;
    }
}