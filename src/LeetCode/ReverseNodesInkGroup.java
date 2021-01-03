package LeetCode;

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        Solution25 s=new Solution25();
    }
}
class Solution25 {
    ListNode start,end,head;
    public ListNode reverseKGroup(ListNode h, int k) {
        ListNode p,a=h,b=h,q=null;
        boolean first=true;
        int i=1;
        while (b!=null){
            if(i%k==0){
                p=b.next;
                b.next=null;
                reverse(a,b);
                if(first){
                    head=start;
                    first=false;
                }
                else
                    q.next=start;
                end.next=p;
                a=b=p;
                q=end;
            }
            else
                b = b.next;
            i++;
        }
        return head;
    }
    public void reverse(ListNode a,ListNode b){
        ListNode follow=null,ahead;
        if(a==null)
            return;
        start=b;
        end=a;
        ahead=a.next;
        while (ahead!=null) {
            a.next=follow;
            follow=a;
            a=ahead;
            ahead=ahead.next;
        }
        a.next=follow;
    }
}