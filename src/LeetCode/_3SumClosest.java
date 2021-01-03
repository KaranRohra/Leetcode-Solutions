package LeetCode;

import java.util.*;

public class _3SumClosest {
    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length,closestSum=0;
        for(int k=0;k<n-2;k++){
            int i=k+1,j=n-1;
            while(i<j){
                if(nums[i]+nums[j]<target-nums[k]){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(i==1 && k==0 && j==n-1){
                        closestSum=sum;
                    }
                    else if(Math.abs(closestSum-target)>Math.abs(sum-target)){
                        closestSum=sum;
                    }
                    i++;
                }
                else if(nums[i]+nums[j]>target-nums[k]){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(j==n-1 && k==0 && i==1){
                        closestSum=sum;
                    }
                    else if(Math.abs(closestSum-target)>Math.abs(sum-target)){
                        closestSum=sum;
                    }
                    j--;
                }
                else{
                    return nums[i]+nums[j]+nums[k];
                }
            }
        }
        return closestSum;
    }
}