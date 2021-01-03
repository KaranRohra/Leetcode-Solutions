package LeetCode;

public class LinkedListCycleII {//VVV IMP
    public static void main(String[] args) {
        ListNode ans=new Solution142().detectCycle(new ListNode(1));
        System.out.println(ans.val);
    }
}
//https://leetcode.com/problems/linked-list-cycle-ii/
class Solution142 {// 1ms
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}