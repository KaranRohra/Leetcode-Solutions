package LeetCode;

import java.util.Scanner;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution234 s=new Solution234();
        System.out.println(s.isPalindrome(s.create()));
    }
}
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        int n = size(head),i=0;
        ListNode p2=head;
        ListNode p1=head;
        while(i!=n/2){
            p2=p2.next;
            i++;
        }
        p2=reverse(p2);
        while(i<n){
            if(p2.val != p1.val)
                return false;
            p2=p2.next;
            p1=p1.next;
            i++;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev,front;
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        prev=null;
        front=head.next;
        while(front!=null){
            head.next=prev;
            prev=head;
            head=front;
            front=front.next;
        }
        head.next=prev;
        return head;
    }
    public int size(ListNode head){
        ListNode p=head;
        int length=0;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }
    public ListNode create(){
        ListNode head=null;
        int option;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1: Insert");
            System.out.println("2: Quit");
            System.out.print("Enter your option:");
            option=sc.nextInt();
            if(option==1){
                System.out.print("Enter your data:");
                head=insertEnd(head,sc.nextInt());
            }
        }while (option==1);
        return head;
    }
    public ListNode insertEnd(ListNode head,int key){
        ListNode ptr=new ListNode(key);
        ListNode p=head;
        if(head==null)
            return ptr;
        else{
            while (p.next!=null)
                p=p.next;
            p.next=ptr;
        }
        return head;
    }
}
