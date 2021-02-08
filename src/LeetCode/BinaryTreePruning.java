package LeetCode;

public class BinaryTreePruning {
    public static void main(String[] args) {
        TreeNode root=new Solution814().pruneTree(new TreeNode().makeTree(1,0,1,0,0,0,1));
        root.display(root);
    }
}
//https://leetcode.com/problems/binary-tree-pruning/
class Solution814 {// 0 ms
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.left==null && root.right==null){
            if(root.val==0)
                return null;
            return root;
        }
        return root;
    }
}