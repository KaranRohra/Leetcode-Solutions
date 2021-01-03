package LeetCode;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution993().isCousins(new TreeNode(1),4,3));
    }
}
//https://leetcode.com/problems/cousins-in-binary-tree/submissions/
class Solution993 {// 0ms
    private TreeNode xParent,yParent;
    private int xParentDepth,yParentDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        searchAndDepth(root,0,x,y);
        return xParent != yParent && xParentDepth == yParentDepth;
    }
    private int searchAndDepth(TreeNode root,int depth,int x,int y){
        if(root==null)
            return depth;
        if(root.left==null && root.right==null)
            return depth;
        if(depth==0){
            if(root.val==x){
                xParent=root;
                xParentDepth=depth;
            }
            if(root.val==y){
                yParent=root;
                yParentDepth=depth;
            }
        }
        if(root.left!=null) {
            if (root.left.val == x) {
                xParent = root;
                xParentDepth=depth;
            }
            if(root.left.val==y) {
                yParent = root;
                yParentDepth=depth;
            }
        }
        if(root.right!=null){
            if (root.right.val == x) {
                xParent = root;
                xParentDepth=depth;
            }
            if(root.right.val==y) {
                yParent = root;
                yParentDepth=depth;
            }
        }

        int leftDepth=searchAndDepth(root.left,depth+1,x,y);
        int rightDepth=searchAndDepth(root.right,depth+1,x,y);
        return Math.max(leftDepth,rightDepth);
    }
}
