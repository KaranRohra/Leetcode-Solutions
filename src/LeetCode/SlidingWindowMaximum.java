package LeetCode;

import java.util.*;

public class SlidingWindowMaximum {//VVV IMP
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
// Reference: https://youtu.be/XDJKHtXJHBY
//https://leetcode.com/problems/sliding-window-maximum/
class Solution239 {// 25 ms
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] maxWindow=new int[n-k+1];
        int i=0,j=0;

        Deque<Integer> dq=new LinkedList<>();
        while(j!=k){
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[j]){
                dq.pollLast();
            }
            dq.offerLast(j);
            j++;
        }
        j--;
        //System.out.println(dq);
        for(;j<n;j++,i++){
            if(dq.getFirst()<i){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[j]){
                dq.pollLast();
            }
            dq.offerLast(j);
            maxWindow[i]=nums[dq.getFirst()];
            while(dq.size()>k){
                dq.pollLast();
            }
        }
        return maxWindow;
    }
}

