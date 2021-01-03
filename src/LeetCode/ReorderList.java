package LeetCode;

public class ReorderList {
    public static void main(String[] args) {
        Solution143 s=new Solution143();
    }
}
class Solution143 {
    public void reorderList(ListNode head) {
        int length=size(head);
        ListNode head1=head,headAhead,head1Ahead,follow=null;
        int i=0;
        while(i!=length/2){
            follow=head1;
            head1=head1.next;
            i++;
        }
        if(length%2!=0){
            follow=head1;
            head1=head1.next;
        }

        if(follow!=null)
            follow.next=null;

        head1=reverse(head1);

        while(head1!=null){
            headAhead=head.next;
            head1Ahead=head1.next;

            head.next=head1;
            head1.next=headAhead;

            head1=head1Ahead;
            head=headAhead;
        }

    }
    private int size(ListNode p){
        int length=0;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }

    private ListNode reverse(ListNode p){
        ListNode follow=null,ahead;
        if(p==null || p.next==null)
            return p;

        ahead=p.next;
        while(ahead!=null){
            p.next=follow;
            follow=p;
            p=ahead;
            ahead=ahead.next;
        }
        p.next=follow;
        return p;
    }
}






