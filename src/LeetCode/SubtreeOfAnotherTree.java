package LeetCode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        System.out.println(new Solution572().isSubtree(new TreeNode().makeTree(3,4,5,1,2),new TreeNode().makeTree(4,1,2)));
    }
}
//https://leetcode.com/problems/subtree-of-another-tree/submissions/
class Solution572 {// 5 ms and 1 incorrect submission
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;
        if(s.val==t.val && isSame(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isSame(TreeNode s,TreeNode t){
        if(s==null && t==null)
            return true;
        if(s==null || t==null)
            return false;
        if(s.val!=t.val)
            return false;
        return isSame(s.left,t.left) && isSame(s.right,t.right);
    }
}


