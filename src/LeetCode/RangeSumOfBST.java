package LeetCode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        System.out.println(new Solution938().rangeSumBST(new TreeNode().makeTree(10,5,15,3,7,null,18),7,15));
    }
}
//https://leetcode.com/problems/range-sum-of-bst/
class Solution938 {// 1 ms
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        if(low==root.val)
            return low;
        if(high==root.val)
            return high;
        int sum=0;
        int leftSum=rangeSumBST(root.left,low,high);
        if(root.val>=low && root.val<=high)
            sum+=root.val+leftSum;
        int rightSum=rangeSumBST(root.right,low,high);
        if(root.val>low && root.val<high)
            sum+=rightSum;
        return sum;
    }
}

