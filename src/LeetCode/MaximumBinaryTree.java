package LeetCode;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new Solution654().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        root.display(root);
    }
}
//https://leetcode.com/problems/maximum-binary-tree/submissions/
class Solution654 {// 2 ms
    private TreeNode root;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        setTree(nums,0,nums.length-1,null,-1);
        return root;
    }
    private void setTree(int[] nums,int start,int end,TreeNode prev,int prevIndex){
        if(start>end)
            return;
        int index=maxIndex(nums,start,end);

        if(index==-1)
            return;

        TreeNode curr=new TreeNode(nums[index]);
        if(prev==null){
            root=curr;
        } else if(index<prevIndex){
            prev.left=curr;
        } else if(index>prevIndex){
            prev.right=curr;
        }

        setTree(nums,start,index-1,curr,index);
        setTree(nums,index+1,end,curr,index);

    }
    private int maxIndex(int[] nums,int start,int end){
        int max=0,index=-1;
        while(start<=end){
            if(nums[start]>=max){
                max=nums[start];
                index=start;
            }
            start++;
        }
        return index;
    }
}





