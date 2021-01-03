package LeetCode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution2 s=new Solution2();
        MyLinkedList l1=new MyLinkedList();
        MyLinkedList l2=new MyLinkedList();
        l1.addAtTail(1);
        l1.addAtTail(2);
        l1.addAtTail(3);

        l2.addAtTail(7);
        l2.addAtTail(8);
        l2.addAtTail(9);

        MyLinkedList l3=new MyLinkedList();
        l3.head=s.addTwoNumbers(l1.head,l2.head);
        int i=0;
        while (l3.get(i)!=-1)
            System.out.print(l3.get(i++)+" ");
        //123 <- 1st number
        //789 <- 2nd number
        //8031 <- sum of 1st and 2nd number
    }
}
class Solution2 {
    ListNode head;
    ListNode tail;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        while (l1!=null && l2!=null){
            int sum=l1.val+l2.val+carry;
            carry=sum/10;
            insertTail(sum%10);
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int sum=l1.val+carry;
            carry=sum/10;
            insertTail(sum%10);
            l1=l1.next;
        }
        while (l2!=null){
            int sum=l2.val+carry;
            carry=sum/10;
            insertTail(sum%10);
            l2=l2.next;
        }
        if(carry==1)
            insertTail(1);
        return head;
    }
    public void insertTail(int data){
        ListNode ptr=new ListNode(data);
        if(head==null)
            head=ptr;
        else
            tail.next=ptr;
        tail=ptr;
    }
}
