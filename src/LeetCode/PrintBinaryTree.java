package LeetCode;

import java.util.*;

public class PrintBinaryTree {
    public static void main(String[] args) {
        List<List<String>> printTree=new Solution655().printTree(new TreeNode().makeTree(1,2,5,3,null,null,null,4));
        for(List<String> list:printTree){
            System.out.print("[");
            for(String string:list){
                System.out.print(string+", ");
            }
            System.out.println("]");
        }
    }
}
//https://leetcode.com/problems/print-binary-tree/
class Solution655{// 2 ms
    public List<List<String>> printTree(TreeNode root) {
        return fillList(root);
    }

    private List<List<String>> fillList(TreeNode root){
        List<List<String>> res=getList(root);

        int width=(int)Math.pow(2,res.size())-1;
        int depth=0;
        Queue<TreeNode> bfs=new LinkedList<>();

        bfs.offer(root);
        while(!bfs.isEmpty()){
            int n=bfs.size();
            width/=2;
            for(int i=0,w=width;i<n;i++,w+=width*2+2){
                TreeNode p=bfs.poll();
                if(p!=null){
                    //System.out.println(p.val);
                    res.get(depth).set(w,String.valueOf(p.val));
                    bfs.offer(p.left);
                    bfs.offer(p.right);
                }
                else if(depth!=res.size()){
                    bfs.offer(null);
                    bfs.offer(null);
                }
            }
            depth++;
        }
        return res;
    }

    private List<List<String>> getList(TreeNode root){
        int depth=depthOfTree(root);
        int width=(int)Math.pow(2,depth)-1;

        List<List<String>> list=new ArrayList<>();
        for(int i=0;i<depth;i++){
            List<String> temp=new ArrayList<>();
            for(int j=0;j<width;j++){
                temp.add("");
            }
            list.add(temp);
        }
        return list;
    }

    private int depthOfTree(TreeNode root){
        if(root==null)
            return 0;
        int leftDepth=depthOfTree(root.left);
        int rightDepth=depthOfTree(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}






