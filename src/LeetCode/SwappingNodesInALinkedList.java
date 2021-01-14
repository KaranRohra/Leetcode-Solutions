package LeetCode;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode head=new Solution1721().swapNodes(new ListNode(1),5);
    }
}
//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
class Solution1721 {// 2 ms
    public ListNode swapNodes(ListNode head, int k) {
        ListNode a=head,b=head;
        ListNode p=head;
        int i=1;
        while(p!=null){
            if(i==k)
                a=p;
            if(i>k)
                b=b.next;
            p=p.next;
            i++;
        }
        if(head!=null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
        return head;
    }
}