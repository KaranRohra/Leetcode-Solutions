package LeetCode;

import java.util.*;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution501().findMode(new TreeNode().makeTree(1,null,2,2))));
    }
}
//https://leetcode.com/problems/find-mode-in-binary-search-tree/
class Solution501 {// 0 ms and 1 incorrect submission
    Integer max=-1,count=0,num;
    ArrayList<Integer> res;

    Solution501(){
        res=new ArrayList<>();
    }
    public int[] findMode(TreeNode root) {
        if(root==null)
            return new int[0];
        find(root);
        verify();
        int n = res.size();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
    private void find(TreeNode root){
        if(root==null){
            return ;
        }

        find(root.left);

        if(num==null){
            count=0;
            num=root.val;
        }

        if(num==root.val){
            count++;
        }
        else{
            verify();

            num=root.val;
            count=1;
        }

        find(root.right);
    }
    private void verify(){
        if(count>max){
            res=new ArrayList<>();
            max=count;
        }

        if(max.equals(count)){
            res.add(num);
        }
    }
}

