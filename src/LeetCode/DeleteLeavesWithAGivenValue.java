package LeetCode;

public class DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        TreeNode root=new Solution1325().removeLeafNodes(new TreeNode().makeTree(1,2,3,4,5,2,2,2),2);
        root.display();
    }
}
//https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/
class Solution1325 {// 0ms
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)
            return null;
        removeLeafNodes(root,null,target);
        if(root.right==null && root.left==null && root.val==target)
            return null;
        return root;
    }
    private void removeLeafNodes(TreeNode p, TreeNode prev, int t){
        if(p==null)
            return;
        deleteTargetLeaf(p,prev,t);

        removeLeafNodes(p.left,p,t);
        removeLeafNodes(p.right,p,t);

        deleteTargetLeaf(p,prev,t);
    }
    private void deleteTargetLeaf(TreeNode p,TreeNode prev,int t){
        if(p!=null && p.left==null && p.right==null && p.val==t){
            if(prev.left==p)
                prev.left=null;
            else if(prev.right==p)
                prev.right=null;
        }
    }
}