package LeetCode;

public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        System.out.println(new Solution530().getMinimumDifference(new TreeNode(1)));
    }
}
//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
class Solution530 {// 0 ms or 1 ms
    private int min;
    private TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        min=Integer.MAX_VALUE;
        getMinimumDifference1(root);
        return min;
    }
    private void getMinimumDifference1(TreeNode root){
        if(root==null)
            return;
        getMinimumDifference1(root.left);
        if(prev!=null)
            min=Math.min(min,root.val-prev.val);

        prev=root;

        getMinimumDifference1(root.right);
    }
}
/*
class Solution {// 2 ms
    List<Integer> a;
    int n,min;
    public int getMinimumDifference(TreeNode root) {
        a=new ArrayList<>();
        min=Integer.MAX_VALUE;
        getMinimumDifference1(root);
        return min;
    }
    private void getMinimumDifference1(TreeNode root){
        if(root==null)
            return;
        getMinimumDifference1(root.left);
        a.add(root.val);
        n++;
        if(n>=2 && a.get(n-1)-a.get(n-2)<min)
            min=a.get(n-1)-a.get(n-2);
        getMinimumDifference1(root.right);
    }
}
 */