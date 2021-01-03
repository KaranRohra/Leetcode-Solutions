package leetCode;

import java.util.Scanner;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution19 s = new Solution19();
        ListNode19 head;

        System.out.print("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        head = new ListNode19(sc.nextInt());
        for(int i=1;i<n;i++)
            head=s.add(head,sc.nextInt());

        head=s.removeNthFromEnd(head,sc.nextInt());

        s.display(head);
    }
}
class ListNode19 {
    int val;
    ListNode19 next;
    ListNode19() {}
    ListNode19(int val) { this.val = val; }
    ListNode19(int val, ListNode19 next) { this.val = val; this.next = next; }
}

class Solution19 {
    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        ListNode19 p1,following,p2;
        int i=0,size=0;
        if(head!=null){
            p1=head;
            following=head;
            p2=head;
            while(p2!=null) {
                if(p1!=null) {
                    p1 = p1.next;
                    size++;
                }
                else{
                    if(size==1)
                        return null;
                    else if(size==n){
                        head=head.next;
                        return head;
                    }
                    else if(size == n+i){
                        following.next=p2.next;
                        return head;
                    }
                    following=p2;
                    p2=p2.next;
                    i++;
                }
            }
        }
        return head;
    }
    public ListNode19 add(ListNode19 head,int n){
        ListNode19 ptr = new ListNode19(n);
        ListNode19 p = head;
        if(head==null)
            head=ptr;
        else{
            while(p.next!=null)
                p=p.next;
            p.next=ptr;
        }
        return head;
    }
    public void display(ListNode19 head){
        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}