package LeetCode;

import java.util.*;

public class AllPathsFromSourceToTarget {// VVV IMP
    public static void main(String[] args) {
        System.out.println(new Solution797().allPathsSourceTarget(new int[][]{
                {4,3,1},{3, 2, 4},{3},{4},{}
        }));
    }
}
//https://leetcode.com/problems/all-paths-from-source-to-target/
class Solution797 {// 6 ms
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = dfs(graph, 0);
        return res == null ? new ArrayList<>() : res;
    }

    private List<List<Integer>> dfs(int[][] graph, int v) {
        List<List<Integer>> res = new ArrayList<>();
        if (v == graph.length-1) {
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
        //System.out.println(res);
        return n == 0 ? null : res;
    }
}