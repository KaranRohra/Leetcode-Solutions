package leetCode;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution83 s = new Solution83();
        ListNode83 head;
        System.out.print("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        head = new ListNode83(sc.nextInt());
        for(int i=1;i<n;i++)
            head=s.add(head,sc.nextInt());

        head=s.deleteDuplicates(head);

        s.display(head);
    }
}
class ListNode83{
    int val;
    ListNode83 next;
    ListNode83() {}
    ListNode83(int val) { this.val = val; }
}

class Solution83 {
    public ListNode83 deleteDuplicates(ListNode83 head) {
        ListNode83 cur = head;
        ListNode83 following;
        if(head!=null){
            following=head.next;
            while(following!=null){
                if(cur.val==following.val){
                    cur.next=null;
                }
                else{
                    cur.next=following;
                    cur=following;
                }
                following=following.next;
            }
        }
        return head;
    }
    public ListNode83 add(ListNode83 head,int n){
        ListNode83 ptr = new ListNode83(n);
        ListNode83 p = head;
        if(head==null)
            head=ptr;
        else{
            while(p.next!=null)
                p=p.next;
            p.next=ptr;
        }
        return head;
    }
    public void display(ListNode83 head){
        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}