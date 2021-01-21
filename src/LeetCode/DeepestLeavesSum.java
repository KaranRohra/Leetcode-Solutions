package LeetCode;

import java.util.*;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        System.out.println(new Solution1302().deepestLeavesSum(new TreeNode().makeTree(1,2,3,4,5,null,6,7,null,null,null,null,8)));
    }
}
//https://leetcode.com/problems/deepest-leaves-sum/
class Solution1302 {// dfs 0 ms and bfs 4ms
    private int sum,deepLevel;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    private void dfs(TreeNode root,int level){// 0 ms
        if(root==null)
            return;
        if(deepLevel==level){
            sum+=root.val;
        }
        else if(level>deepLevel){
            deepLevel=level;
            sum=root.val;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    private int bfs(TreeNode root){// 4 ms
        Queue<TreeNode> bfs=new ArrayDeque<>();
        int res=0;
        if(root==null)
            return 0;
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int n=bfs.size();
            res=0;
            for(int i=0;i<n;i++){
                TreeNode p=bfs.poll();
                if(p!=null){
                    res+=p.val;
                    if(p.left!=null)
                        bfs.offer(p.left);
                    if(p.right!=null)
                        bfs.offer(p.right);
                }
            }
        }
        return res;
    }
}