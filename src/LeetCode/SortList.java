package LeetCode;

public class SortList {
    public static void main(String[] args) {
        Solution148 s=new Solution148();
    }
}
class Solution148 {
    private ListNode head,tail;
    private ListNode tempHead,tempTail;
    public ListNode sortList(ListNode head) {
        int length=size(head);

        ListNode temp=new ListNode();
        temp.next=head;
        head=temp;

        this.head=head;

        mergeSort(head.next,0,tail,length-1);
        return head.next;
    }

    private void mergeSort(ListNode left,int leftBound,ListNode right,int rightBound){
        if(leftBound<rightBound){
            int midIndex=(leftBound+rightBound)/2;
            ListNode mid=left;
            for (int i=leftBound;i!=midIndex;i++){
                mid=mid.next;
            }

            mergeSort(left,leftBound,mid,midIndex);
            mergeSort(mid.next,midIndex+1,right,rightBound);

            merge(left,mid,right);
        }
    }

    private void merge(ListNode left,ListNode mid,ListNode right){
        ListNode i=left,j=mid.next;
        while (i!=mid.next && j!=right.next){
            if(i.val<j.val){
                add(i.val);
                i=i.next;
            }
            else if(i.val>j.val){
                add(j.val);
                j=j.next;
            }
            else{
                add(i.val);
                add(j.val);

                i=i.next;
                j=j.next;
            }
        }

        while (i!=mid.next){
            add(i.val);
            i=i.next;
        }

        while (j!=right.next){
            add(j.val);
            j=j.next;
        }

        i=tempHead;
        while(i!=null){
            left.val=i.val;
            left=left.next;
            i=i.next;
        }

        tempHead=null;
        tempTail=null;
    }

    private void add(int val) {
        ListNode toInsert=new ListNode(val);
        if(tempHead==null)
            tempHead=toInsert;
        else
            tempTail.next=toInsert;
        tempTail=toInsert;
    }

    private int size(ListNode p){
        int length=0;
        while(p!=null){
            if(p.next==null)
                tail=p;
            p=p.next;
            length++;
        }
        return length;
    }
}


