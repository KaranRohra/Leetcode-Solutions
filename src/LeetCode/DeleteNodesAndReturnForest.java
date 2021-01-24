package LeetCode;

import java.util.*;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        System.out.println(new Solution1110().delNodes(new TreeNode().makeTree(1,2,3,4,5,6,7),new int[]{3,5}));
    }
}
//https://leetcode.com/problems/delete-nodes-and-return-forest/submissions/
class Solution1110 {// 1 ms
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null)
            return new ArrayList<>();

        boolean[] present=new boolean[1001];
        for(int i:to_delete)
            present[i]=true;
        TreeNode[] forest=new TreeNode[1001];
        forest[root.val]=root;
        makeForest(null,root,present,forest);

        List<TreeNode> res=new ArrayList<>();
        for(int i=1;i<1001;i++){
            if(forest[i]!=null)
                res.add(forest[i]);
        }
        return res;
    }
    public void makeForest(TreeNode prev,TreeNode curr,boolean[] present,TreeNode[] forest){
        if(curr==null)
            return;
        if(present[curr.val]){
            TreeNode leftSubtree=curr.left;
            TreeNode rightSubtree=curr.right;
            if(prev==null){
                if(forest[curr.val]!=null){
                    forest[curr.val]=null;
                }
            }else if(prev.left==curr){
                prev.left=null;
            }else{
                prev.right=null;
            }

            if(leftSubtree!=null){
                forest[leftSubtree.val]=leftSubtree;
            }
            if(rightSubtree!=null){
                forest[rightSubtree.val]=rightSubtree;
            }
            curr.left=null;
            curr.right=null;
            makeForest(null,leftSubtree,present,forest);
            makeForest(null,rightSubtree,present,forest);
        }
        else{
            makeForest(curr,curr.left,present,forest);
            makeForest(curr,curr.right,present,forest);
        }
    }
}