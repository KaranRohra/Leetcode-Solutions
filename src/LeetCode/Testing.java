package LeetCode;

import java.math.BigInteger;
import java.util.*;

public class Testing {
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{2,2,2,2,3,4,5},4));
        System.out.println(new Solution().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1},4));
    }
}
class Solution {
    int[][] dp;
    int[] isVisited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length,sum=0;
        for(int i:nums)
            sum+=i;
        if(sum%k!=0)
            return false;
        isVisited=new int[n];
        for(int i=n;i>0;i--) {
            countSubset(nums, i, sum / k);
            for (int j : isVisited) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        return true;
    }
    public int countSubset(int[] a,int n,int sum){
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        int count;
        if(a[n-1]<=sum && isVisited[n-1]==0){
            count=countSubset(a,n-1,sum-a[n-1]);
            if(count==1){
                isVisited[n-1]=1;
                return 1;
            }
        }
        count=countSubset(a,n-1,sum);
        return count;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode makeTree(Integer ...a){
        return new TreeNode(1);
    }

    public void display() {

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
