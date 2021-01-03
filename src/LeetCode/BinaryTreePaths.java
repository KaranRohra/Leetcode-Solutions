package LeetCode;

import java.util.*;

public class BinaryTreePaths {
    public static void main(String[] args) {
        System.out.println(new Solution257().binaryTreePaths(new TreeNode()));
    }
}
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        travel(root,"",result);
        return result;
    }

    private void travel(TreeNode root,String str,List<String> a){
        if(root==null)
            return;

        String temp=str.equals("")?str.concat(String.valueOf(root.val)):str.concat("->").concat(String.valueOf(root.val));

        if(root.left==null && root.right==null){
            a.add(temp);
        }

        travel(root.left,temp,a);
        travel(root.right,temp,a);
    }
}