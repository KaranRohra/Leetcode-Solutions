package LeetCode;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {// VVV IMP And Interesting, learned traversal without recursion
    public static void main(String[] args) {
        System.out.println(new Solution1305().getAllElements(new TreeNode().makeTree(1,2,4),new TreeNode().makeTree(0,1,3)));
    }
}
//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
class Solution1305 {
    List<Integer> a,b;
    int i=0,n;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        a=new ArrayList<>();
        b=new ArrayList<>();
        fillList1(root1);
        n=a.size();
        fillList2(root2);
        int size=a.size();
        while(i<size){
            b.add(a.get(i));
            i++;
        }
        return b;
    }

    private void fillList1(TreeNode p){
        if(p==null)
            return;
        fillList1(p.left);
        a.add(p.val);
        fillList1(p.right);
    }

    private void fillList2(TreeNode p){
        if(p==null)
            return;
        fillList2(p.left);
        if(i==n)
            b.add(p.val);
        else if(i<n){
            int x=a.get(i);
            while(i<n && p.val>a.get(i)){
                b.add(a.get(i));
                i++;
            }
            b.add(p.val);
        }
        fillList2(p.right);
    }
}
/*
class Solution1305 {//16 ms
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        fillStackWithLeftNodes(stack1, root1);
        fillStackWithLeftNodes(stack2, root2);

        int numberOfNodesInTree1, numberOfNodesInTree2;
        numberOfNodesInTree1 = countNodes(root1);
        numberOfNodesInTree2 = countNodes(root2);

        int numberOfNodes = numberOfNodesInTree1 + numberOfNodesInTree2;
        for (int i = 0, j = 0, k = 0; i < numberOfNodes; i++) {
            if (j == numberOfNodesInTree1) {
                fillData(a, stack2);
                //System.out.println(j+" "+k+" "+numberOfNodesInTree1+" "+numberOfNodesInTree2);
                continue;
            }
            if (k == numberOfNodesInTree2) {
                //System.out.println(j+" "+k+" "+i);
                fillData(a, stack1);
                continue;
            }
            if (stack1.peek().val < stack2.peek().val) {
                fillData(a, stack1);
                j++;
            } else if (stack2.peek().val < stack1.peek().val) {
                fillData(a, stack2);
                k++;
            } else {
                fillData(a, stack1);
                fillData(a, stack2);
                i++;
                j++;
                k++;
            }
            //System.out.println(j+" "+k+" "+numberOfNodesInTree1+" "+numberOfNodesInTree2);
        }

        return a;
    }

    private void fillStackWithLeftNodes(Stack<TreeNode> stack, TreeNode p) {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    private void fillData(List<Integer> a, Stack<TreeNode> stack) {
        TreeNode p = stack.pop();
        a.add(p.val);
        fillStackWithLeftNodes(stack, p.right);
    }

    private int countNodes(TreeNode p) {
        if (p == null)
            return 0;
        int leftCount = countNodes(p.left);
        int rightCount = countNodes(p.right);
        return leftCount + rightCount + 1;
    }
}*/