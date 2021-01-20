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

        //System.out.println(new Solution().allPathsSourceTarget(5, graph));
    }
}
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = dfs(graph, 0);
        return res == null ? new ArrayList<>() : res;
    }

    private List<List<Integer>> dfs(int[][] graph, int v) {
        List<List<Integer>> res = new ArrayList<>();
        if (v == graph.length) {
            res.add(new ArrayList<>(Collections.singletonList(v)));
            return res;
        }

        int n = graph[v].length;

        for (int i = 0; i < n; i++) {
            List<List<Integer>> temp = dfs(graph, graph[v][i]);
            if (temp != null) {

                res.addAll(temp);
            }
        }

        n = res.size();
        for (int i = 0; i < n; i++) {
            res.get(i).add(0,v);
        }
        return n == 0 ? null : res;
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
