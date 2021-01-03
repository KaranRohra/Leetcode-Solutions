package LeetCode;

public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution606().tree2str(new TreeNode(0)));
    }
}
//https://leetcode.com/problems/construct-string-from-binary-tree/
class Solution606 {//1 ms
    private StringBuilder str;
    public String tree2str(TreeNode t) {
        str=new StringBuilder();
        travel(t);
        return str.toString();
    }
    private void travel(TreeNode p){
        if(p==null)
            return;
        boolean first=false;
        if(str.length()==0){
            str.append(p.val);
            first=true;
        }
        else
            str.append('(').append(p.val);

        if(p.left==null && p.right!=null)
            str.append("()");
        else
            travel(p.left);
        if(p.right==null && !first)
            str.append(')');
        else
            travel(p.right);

        if(p.right!=null && !first)
            str.append(')');
    }
}