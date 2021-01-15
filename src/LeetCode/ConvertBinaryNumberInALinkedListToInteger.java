package LeetCode;

public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        System.out.println(new Solution1290().getDecimalValue(new ListNode(1)));
    }
}
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
class Solution1290 {// 0 ms
    public int getDecimalValue(ListNode head) {
        int n=0;
        int i=0;
        head=reverse(head);
        while(head!=null){
            n+=Math.pow(2,i)*head.val;
            head=head.next;
            i++;
        }
        return n;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prev=null,ahead=head.next;
        while(head!=null){
            head.next=prev;
            prev=head;
            head=ahead;
            if(ahead!=null)
                ahead=ahead.next;
        }
        return prev;
    }
}