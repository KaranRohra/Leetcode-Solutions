package LeetCode;

import java.util.*;

public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1019().nextLargerNodes(new ListNode(1))));
    }
}
//https://leetcode.com/problems/next-greater-node-in-linked-list/submissions/
class Solution1019 {// 15 ms
    private int[] res;
    public int[] nextLargerNodes(ListNode head) {
        fillNextLargerNodes(head,new Stack<>(),0);
        return res;
    }
    private void fillNextLargerNodes(ListNode head,Stack<Integer> s,int i){
        if(head==null){
            res=new int[i];
            return;
        }
        fillNextLargerNodes(head.next,s,i+1);
        while(!s.isEmpty() && s.peek()<=head.val){
            s.pop();
        }
        if(!s.isEmpty()){
            res[i]=s.peek();
        }
        s.push(head.val);
    }
}