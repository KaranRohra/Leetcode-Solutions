package LeetCode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution24 s=new Solution24();
    }
}
class Solution24 {
    public ListNode swapPairs(ListNode h) {
        ListNode p1,p2,p3;
        if(h==null || h.next==null)
            return h;
        p3=null;
        p2=h;
        p1=h.next;
        while (p1!=null){
            if(p3==null)
                h=p1;
            else
                p3.next=p1;
            p2.next=p1.next;
            p1.next=p2;

            p3=p2;
            p2=p2.next;
            if(p2==null)
                break;
            p1=p2.next;
        }
        return h;
    }
}