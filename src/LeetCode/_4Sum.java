package LeetCode;

import java.util.*;

public class _4Sum {
    public static void main(String[] args) {
        System.out.println(new Solution18().fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();

        Arrays.parallelSort(nums);
        int n=nums.length;
        for(int x=0;x<n-3;){
            for(int k=x+1;k<n-2;){
                int i=k+1;
                int j=n-1;
                while(i<j){
                    if(nums[i]+nums[j]+nums[k]+nums[x]<target)
                        i++;
                    else if(nums[i]+nums[j]+nums[k]+nums[x]>target)
                        j--;
                    else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[x]));
                        int y=nums[i];
                        while(i<j && y==nums[i])
                            i++;
                        y=nums[j];
                        while(i<j && y==nums[j])
                            j--;
                    }
                }
                int y=nums[k];
                while(k<n-2 && y==nums[k])
                    k++;
            }
            int y=nums[x];
            while(x<n-3 && y==nums[x])
                x++;
        }
        return result;
    }
}