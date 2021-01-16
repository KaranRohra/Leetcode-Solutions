package LeetCode;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head=new Solution147().insertionSortList(new ListNode(1));
    }
}
//https://leetcode.com/problems/insertion-sort-list/
//O(n) Extra Space
class Solution147 {//27 ms
    private ListNode head;
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode p=head;
        while(p!=null){
            insert(p.val);
            p=p.next;
        }
        return this.head;
    }
    private void insert(int val){
        ListNode ptr=new ListNode(val);
        if(head==null){
            head=ptr;
            return;
        }
        ListNode p=head,follow=null;
        while(p!=null){
            if(p.val>=val){
                if(follow==null){
                    ptr.next=head;
                    head=ptr;
                }
                else{
                    ptr.next=p;
                    follow.next=ptr;
                }
                return;
            }

            follow=p;
            p=p.next;
        }
        follow.next=ptr;
    }
}
/*
O(1) Extra Space
class Solution {

    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return head;
        ListNode p=head;
        ListNode tempNode=new ListNode();


        while(p!=null){
            ListNode q=tempNode;
            while(q.next!=null && q.next.val<p.val){
                q=q.next;
            }
            ListNode tempHead=p.next;

            p.next=q.next;
            q.next=p;

            p=tempHead;
        }
        return tempNode.next;
    }
}
 */


