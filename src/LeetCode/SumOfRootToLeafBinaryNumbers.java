package LeetCode;

public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(new Solution1022().sumRootToLeaf(new TreeNode().makeTree(1,0,1,0,1,0,1)));
    }
}
//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
class Solution1022{ // 0 ms and 0 incorrect
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,new int[32],0);
    }
    private int dfs(TreeNode root,int[] binary,int curr){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            binary[curr]=root.val;
            return binary2Decimal(binary,curr);
        }
        binary[curr]=root.val;
        return dfs(root.left,binary,curr+1) + dfs(root.right,binary,curr+1);
    }
    private int binary2Decimal(int[] binary,int power){
        int res=0;
        for(int i=0;i<32 && power>=0;i++){
            if(binary[i]==1)
                res+=Math.pow(2,power);
            power--;
        }
        return res;
    }
}



