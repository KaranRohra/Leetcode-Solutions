package LeetCode;

import java.util.Scanner;

public class DesignLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList obj = new MyLinkedList();
        int option;
        do {
            System.out.println("1: Get");
            System.out.println("2: Insert at Head");
            System.out.println("3: Insert at Tail");
            System.out.println("4: Insert at Index(Position)");
            System.out.println("5: Delete at Index(Position)");
            System.out.println("6: Quit");
            System.out.print("Enter your option:");
            option=sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter Index:");
                    int index=sc.nextInt();
                    int param_1 = obj.get(index);
                    if(param_1!=-1)
                        System.out.println(param_1+" is present at "+index);
                    else
                        System.out.println("Get operation failed");
                    break;
                case 2:
                    System.out.print("Enter data:");
                    int val = sc.nextInt();
                    obj.addAtHead(val);
                    System.out.println(val+" Inserted");
                    break;
                case 3:
                    System.out.print("Enter data:");
                    val = sc.nextInt();
                    obj.addAtTail(val);
                    System.out.println(val+" Inserted");
                case 4:
                    System.out.print("Enter data:");
                    val = sc.nextInt();
                    System.out.println("Enter index:");
                    index=sc.nextInt();
                    obj.addAtIndex(index, val);
                    System.out.println(val+" Inserted");
                case 5:
                    System.out.println("Enter index:");
                    index=sc.nextInt();
                    obj.deleteAtIndex(index);
            }
        }while (option>=1 && option<=5);
    }
}
class MyLinkedList {
    ListNode head,tail;
    int size;
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || head==null)
            return -1;
        ListNode p=head;
        int count=0;
        while (p!=null && count!=index){
            p=p.next;
            count++;
        }
        if(p==null)
            return -1;
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new ListNode will be the first ListNode of the linked list. */
    public void addAtHead(int val) {
        ListNode ptr=new ListNode(val);
        ptr.next=head;
        if(head==null)
            tail=ptr;
        head=ptr;
        size++;
        // display();
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode ptr=new ListNode(val);
        if(tail==null)
            head = ptr;
        else
            tail.next = ptr;
        tail = ptr;
        size++;
        // display();
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the ListNode will be appended to the end of linked list. If index is greater than the length, the ListNode will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size || index<0)
            return;
        ListNode ptr=new ListNode(val);
        ListNode p=head,follow=head;
        int count=0;
        while (p!=null && count!=index){
            count++;
            follow=p;
            p=p.next;
        }
        if(p==head) {
            if(p == null) {
                head = ptr;
                tail=ptr;
            }
            else {
                ptr.next = head;
                head = ptr;
            }
            size++;
        }
        else if(p==tail){
            ptr.next=p;
            follow.next=ptr;
            size++;
        }
        else if(p==null){
            follow.next=ptr;
            tail=ptr;
            size++;
        }
        else {
            ptr.next = p;
            follow.next = ptr;
            size++;
        }
    }
    /** Delete the index-th ListNode in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0)
            return;
        ListNode p=head,follow=head;
        int count=0;
        if(head!=null){
            if(head.next==null && index==0) {
                head = null;
                tail=null;
                size--;
            }
            else{
                while (p.next!=null && count!=index){
                    count++;
                    follow=p;
                    p=p.next;
                }
                if(index==0){
                    head=head.next;
                    size--;
                }
                else if(p==tail && count==index){
                    follow.next=null;
                    tail=follow;
                    size--;
                }
                else if(index==count){
                    follow.next=p.next;
                    size--;
                }
            }
        }
    }
}

