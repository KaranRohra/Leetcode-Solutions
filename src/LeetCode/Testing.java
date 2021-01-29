package LeetCode;


import java.util.*;

public class Testing {
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{2,2,2,2,3,4,5},4));
//        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
//
//        graph.add(new ArrayList<>(Arrays.asList(4,5)));// 0 is connected to 1,2,3
//        graph.add(new ArrayList<>(Arrays.asList(2,0)));
//        graph.add(new ArrayList<>(Arrays.asList(0,1)));
//        graph.add(new ArrayList<>(Arrays.asList(1,3)));
//        graph.add(new ArrayList<>(Arrays.asList(3,1)));
//        graph.add(new ArrayList<>(Arrays.asList(1,0)));

        System.out.println(new Solution().partitionLabels( "ababcbacadefegdehijhklij"));
        //System.out.println(new Solution().reverseBits(-3));
    }
}
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        char[] str=S.toCharArray();
        int n=str.length,end=0,start=0;

        int[] cnt=new int[26];
        for(char c:str)
            cnt[c-'a']++;

        //ababcbacadefegdehijhklij
        while(end<n){
            cnt[str[end]-'a']--;
            if(isPartitioned(cnt,str,start,end)){
                res.add(end-start+1);
                start=end+1;
            }
            end++;
        }
        return res;
    }
    private boolean isPartitioned(int[] cnt,char[] str,int start,int end){
        while (start<=end){
            if(cnt[str[start]-'a']!=0)
                return false;
            start++;
        }
        return true;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode makeTree(Integer ...a){
        return new TreeNode(1);
    }

    public void display() {

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
