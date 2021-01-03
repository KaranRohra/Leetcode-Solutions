package LeetCode;

import java.math.BigInteger;
import java.util.*;

public class Testing {
    public static void main(String[] args) {
//        int count=0;
//        count+=(123456789%10+123456789)/10;
//        for (int i=1;i<=1000;i++)
//            System.out.println(i);
//        System.out.println(count);
        //System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{4, 3, 1, 2, 5, 3, 4, 7, 1, 9}, 4)));

    }
}
class Solution
{

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode makeTree(Integer ...a){
        return new TreeNode(1);
    }

    public void display() {

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
