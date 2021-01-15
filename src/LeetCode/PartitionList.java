package LeetCode;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head=new Solution86().partition(new ListNode(1),3);
    }
}
//https://leetcode.com/problems/partition-list/
class Solution86 {// 0 ms
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode head1=null,tail1=null;
        ListNode head2=null,tail2=null;

        while(head!=null){
            if(head.val<x){
                if(head1==null){
                    head1=tail1=add(head.val, null, null);
                }else{
                    tail1=add(head.val,head1,tail1);
                }
            }
            else{
                if(head2==null){
                    head2=tail2=add(head.val, null, null);
                }else{
                    tail2=add(head.val,head2,tail2);
                }
            }
            head=head.next;
        }
        if(tail1!=null)
            tail1.next=head2;
        else
            return head2;

        return head1;
    }
    public ListNode add(int val,ListNode head,ListNode tail){
        ListNode ptr=new ListNode(val);
        if(head==null){
            return ptr;
        }
        else{
            tail.next=ptr;
        }
        return ptr;
    }

}