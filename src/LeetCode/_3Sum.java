package LeetCode;

import java.util.*;

public class _3Sum {// VVV IMP
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
class Solution15 {// 16ms
    List<List<Integer>> result;
    public List<List<Integer>> threeSum(int[] nums) {
        result=new ArrayList<>();

        Arrays.sort(nums);

        int n=nums.length;

        for(int i=0;i<n-2;){
            twoSum(nums, -nums[i], i + 1, n - 1);
            int x=nums[i];
            while(i<n-2 && x==nums[i])
                i++;
        }
        return result;
    }
    public void twoSum(int[] a, int target, int i, int j){

        while(i<j){

            if(a[i]+a[j]<target)
                i++;
            else if(a[i]+a[j]>target)
                j--;
            else{
                result.add(new ArrayList<>(
                        Arrays.asList(
                                a[i],a[j],-target
                        )
                ));
                int x=a[i];
                while (i<j && a[i]==x)
                    i++;
                x=a[j];
                while (i<j && a[j]==x)
                    j--;
            }
        }
    }
}
