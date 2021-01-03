package LeetCode;

import java.util.*;

public class PathSumII {
    public static void main(String[] args) {
        Solution113 s=new Solution113();
        //s.pathSum();
    }
}
class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=findPathSum(root,sum);
        return result==null?new ArrayList<>():result;

    }
    public List<List<Integer>> findPathSum(TreeNode root, int sum) {
        if(root==null && sum==0)
            return null;
        if(root==null)
            return null;
        if(root.left==null && root.right==null && root.val-sum==0){
            List<List<Integer>> a=new ArrayList<>();
            a.add(new LinkedList<>());
            a.get(a.size()-1).add(root.val);
            return a;
        }
        List<List<Integer>> leftList=findPathSum(root.left,sum-root.val);
        List<List<Integer>> rightList=findPathSum(root.right,sum-root.val);
        if(leftList==null && rightList==null)
            return null;
        else if(leftList==null) {
            for (List<Integer> integers : rightList) {
                integers.add(0, root.val);
            }
            return rightList;
        }
        else if(rightList==null) {
            for (List<Integer> integers : leftList) {
                integers.add(0, root.val);
            }
            return leftList;
        }
        else{
            rightList.addAll(leftList);
            for (List<Integer> integers : rightList) {
                integers.add(0, root.val);
            }
            return rightList;
        }
    }
}

