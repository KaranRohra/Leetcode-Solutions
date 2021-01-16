package LeetCode;


import java.util.*;

public class Testing {
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println(new Solution().canPartitionKSubsets(new int[]{2,2,2,2,3,4,5},4));
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        graph.add(new ArrayList<>(Arrays.asList(4,5)));// 0 is connected to 1,2,3
        graph.add(new ArrayList<>(Arrays.asList(2,0)));
        graph.add(new ArrayList<>(Arrays.asList(0,1)));
        graph.add(new ArrayList<>(Arrays.asList(1,3)));
        graph.add(new ArrayList<>(Arrays.asList(3,1)));
        graph.add(new ArrayList<>(Arrays.asList(1,0)));

        System.out.println(new Solution().isCyclic(5, graph));
    }
}
class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        int n=adj.size();
        for(int i=0;i<n;i++){
            int m=adj.get(i).size();
            for(int j=0;j<m;j++){
                if(adj.get(i).get(j)==i)
                    return true;
            }
        }
        return false;

    }
    // private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,int count){
    //     isVisited[v]=true;
    //     int n=adj.get(v).size();
    //     for(int i=0;i<n;i++){
    //         int x=adj.get(v).get(i);
    //         if(x==v)
    //             return true;
    //         if(dfs(x,adj,count+1))
    //             return true;

    //     }
    //     return false;
    // }
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
