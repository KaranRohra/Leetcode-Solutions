package LeetCode;

public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode[] ans=new Solution725().splitListToParts(new ListNode(1),5);
    }
}
class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans=new ListNode[k];
        int size=size(head);

        int splitSize=size/k;
        if(splitSize==0)
            splitSize++;

        int adjustmentSize=k>size ? 0 : size%k;

        int ansLength=0;
        ListNode p=head,follow=null;
        while(p!=null){
            int i=0;
            ans[ansLength++]=p;

            while(p!=null && i!=splitSize){
                follow=p;
                p=p.next;
                i++;
            }

            if(adjustmentSize!=0){
                follow=p;
                p=p.next;
                adjustmentSize--;
            }
            follow.next=null;
        }

        return ans;
    }
    public int size(ListNode p){
        int length=0;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }
}