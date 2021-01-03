package leetCode;

import java.util.*;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1544 s = new Solution1544();
        System.out.println(s.makeGood(sc.next()));
    }
}
class Solution1544{
    public String makeGood(String s){
        MyStack a=new MyStack();
        char[] str=s.toCharArray();
        int n=str.length,k=n-1;
        for (char c : str) {
            if (c == a.peek() + 32 || c + 32 == a.peek())
                a.pop();
            else
                a.push(c);
        }
        while(a.peek()!='?'){
            str[k--]=a.peek();
            a.pop();
        }
        return String.valueOf(str).substring(k+1);
    }
}
class MyStack{
    Node head;
    public void push(char data){
        Node ptr=new Node(data);
        ptr.next=head;
        head=ptr;
    }
    public void pop(){
        head=head.next;
    }
    public char peek(){
        if(head==null)
            return '?';
        return head.data;
    }
}
class Node{
    char data;
    Node next;
    Node(char data){
        this.data=data;
        next=null;
    }
}