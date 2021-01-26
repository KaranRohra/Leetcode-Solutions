package LeetCode;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public static void main(String[] args) {
        System.out.println(new Solution865().subtreeWithAllDeepest(new TreeNode().makeTree(3,5,1,6,2,0,8,null,null,7,4)));
    }
}
//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
class Solution865 {// 0 ms
    private TreeNode res;
    private int depth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth=depth(root);
        dfs(root,0);
        return res;
    }
    private int depth(TreeNode root){
        if(root==null)
            return 0;
        int leftDepth=depth(root.left);
        int rightDepth=depth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
    private int dfs(TreeNode root,int level){
        if(root==null)
            return level;
        int leftDepth=dfs(root.left,level+1);
        int rightDepth=dfs(root.right,level+1);
        if(leftDepth==depth && rightDepth==depth)
            res=root;
        return Math.max(leftDepth,rightDepth);
    }
}





