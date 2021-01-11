package LeetCode;

public class FindCorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public static void main(String[] args) {
        TreeNode target=new Solution1379().getTargetCopy(// This is the wrong code i you want to change you can
                new TreeNode().makeTree(7,4,3,null,null,6,19),
                new TreeNode().makeTree(7,4,3,null,null,6,19),
                new TreeNode(3)
        );
    }
}
class Solution1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null)
            return null;
        if(target==original)
            return cloned;
        TreeNode leftTarget=getTargetCopy(original.left,cloned.left,target);
        if(leftTarget!=null)
            return leftTarget;
        return getTargetCopy(original.right,cloned.right,target);
    }
}