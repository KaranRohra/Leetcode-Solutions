package LeetCode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {//VVV IMP
    public static void main(String[] args) {
        System.out.println(new Solution987().verticalTraversal(new TreeNode().makeTree(3,9,20,null,null,15,7)));
    }
}
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
class Solution987 {// 5 ms
    HashMap<TreeNode,Integer> map;
    int minIndex,maxIndex;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map=new HashMap<>();

        minIndex=Integer.MAX_VALUE;
        maxIndex=Integer.MIN_VALUE;

        fillHashMap(root,0);

        return bfs(root);
    }
    public void fillHashMap(TreeNode root,int index){
        if(root==null)
            return;
        map.put(root,index);

        minIndex=Math.min(minIndex,index);
        maxIndex=Math.max(maxIndex,index);

        fillHashMap(root.left,index-1);
        fillHashMap(root.right,index+1);
    }
    public List<List<Integer>> bfs(TreeNode root){

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=minIndex;i<=maxIndex;i++){
            ans.add(new ArrayList<>());
        }
        minIndex=-minIndex;

        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null)
            q.offer(root);
        while (!q.isEmpty()){
            int n=q.size();
            HashMap<Integer,ArrayList<Integer>> temp=new HashMap<>();
            for(int i=0;i<n;i++){
                TreeNode p=q.poll();
                if(p!=null){
                    int index=map.get(p) + minIndex;
                    if (!temp.containsKey(index)) {
                        temp.put(index, new ArrayList<>());
                    }
                    temp.get(index).add(p.val);

                    if(p.left!=null)
                        q.offer(p.left);
                    if(p.right!=null)
                        q.offer(p.right);
                }
            }
            for(Map.Entry<Integer,ArrayList<Integer>> sortLists:temp.entrySet()){
                Collections.sort(sortLists.getValue());
                ans.get(sortLists.getKey()).addAll(sortLists.getValue());
            }
        }
        return ans;
    }
}