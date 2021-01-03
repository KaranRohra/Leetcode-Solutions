package LeetCode;

public class SumOfNodesWithEvenValuedGrandparent {
    public static void main(String[] args) {
        System.out.println(new Solution1315().sumEvenGrandparent(new TreeNode().makeTree(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5)));
    }
}
//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/submissions/
class Solution1315 {// 1 ms
    public int sumEvenGrandparent(TreeNode root) {
        return sum(null,null,root);
    }
    private int sum(TreeNode grandParent,TreeNode parent,TreeNode current){
        if(current==null)
            return 0;
        int leftSum=sum(parent,current,current.left);
        int rightSum=sum(parent,current,current.right);
        if(grandParent!=null && grandParent.val%2==0){
            return leftSum+rightSum+current.val;
        }
        else{
            return leftSum+rightSum;
        }
    }
}