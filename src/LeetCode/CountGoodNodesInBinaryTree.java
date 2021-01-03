package LeetCode;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution1448().goodNodes(new TreeNode(1)));
    }
}
//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
class Solution1448 {// 4 ms
    private int[] a;
    private int countGood,n;
    public int goodNodes(TreeNode root) {
        a=new int[100001];
        travel(root);
        return countGood;

//        if(root==null)
//            return 0;
//        return goodNodes(root.left,root.val)+goodNodes(root.right,root.val)+1;
    }
    /*private int goodNodes(TreeNode p,int max){ //2 ms
        if(p==null)
            return 0;
        int good=p.val>=max?1:0;
        int leftGood=goodNodes(p.left,Math.max(p.val,max));
        int rightGood=goodNodes(p.right,Math.max(p.val,max));
        return leftGood+rightGood+good;
    }*/
    private void travel(TreeNode p){
        if(p==null)
            return;
        int i;
        for(i=0;i<n;i++){
            if(a[i]>p.val){
                break;
            }
        }
        if(i==n)
            countGood++;
        a[n++]=p.val;
        travel(p.left);
        travel(p.right);
        n--;
    }


}