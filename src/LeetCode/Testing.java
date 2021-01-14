package LeetCode;

import java.util.*;

public class Testing {
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{2,2,2,2,3,4,5},4));
    }
}
class Solution {
    boolean[] isVisited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        isVisited=new boolean[n];
        dfs(rooms,0);
        for(boolean isVisited: isVisited){
            if(!isVisited)
                return false;
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,int v){
        isVisited[v]=true;
        int n=rooms.get(v).size();
        for(Integer vertex: rooms.get(v)){
            if(!isVisited[vertex]){
                dfs(rooms,vertex);
            }
        }
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
