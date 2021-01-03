package LeetCode;

public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution965().isUnivalTree(new TreeNode(1)));
    }
}
class Solution965 {
    int value;

    public boolean isUnivalTree(TreeNode root) {
        value=root.val;
        return isValid(root);
    }

    private boolean isValid(TreeNode p){
        if(p==null)
            return true;
        if(value!=p.val)
            return false;
        return isValid(p.left) && isValid(p.right);
    }
}