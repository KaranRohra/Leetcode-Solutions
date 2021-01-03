package LeetCode;

public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(new Solution665().checkPossibility(new int[]{3,4,2,3}));
    }
}
class Solution665 {
    public boolean checkPossibility(int[] nums) {
        boolean isPossible=false;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                if(isPossible)
                    return false;
                int temp=nums[i];
                nums[i]=nums[i+1];
                if(i==0 && nums[i]<=nums[i+1]){
                    isPossible=true;
                }
                else if(nums[i-1]<=nums[i] && nums[i]<=nums[i+1])
                    isPossible=true;
                else if(i!=n-2){
                    nums[i]=temp;
                    i++;
                    nums[i]=nums[i+1];
                    if(nums[i-1]<=nums[i] && nums[i]<=nums[i+1])
                        isPossible=true;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}