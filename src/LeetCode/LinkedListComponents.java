package LeetCode;

public class LinkedListComponents {
    public static void main(String[] args) {
        System.out.println(new Solution817().numComponents(new ListNode(),
                new int[]{1,3,4}
                ));
    }
}
//https://leetcode.com/problems/linked-list-components/submissions/
class Solution817 {// 1 ms
    public int numComponents(ListNode head, int[] G) {
        int[] map=new int[10001];
        //int n=G.length;
        for(int i:G)
            map[i]++;
        ListNode p=head;
        int comp=0;
        while(p!=null){
            ListNode temp=p;
            while(p!=null && map[p.val]!=0)
                p=p.next;
            if(p!=temp)
                comp++;
            if(p!=null){
                //System.out.println(p.val);
                p=p.next;
            }
        }
        return comp;
    }
}