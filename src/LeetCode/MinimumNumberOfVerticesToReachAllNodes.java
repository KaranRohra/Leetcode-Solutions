package LeetCode;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges.add(new ArrayList<>(Arrays.asList(4, 2)));

        System.out.println(new Solution1557().findSmallestSetOfVertices(6, edges));
    }
}
class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();

        boolean[] inDegree = new boolean[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!inDegree[i]) {
                res.add(i);
            }
        }
        if (res.size() == 0)
            res.add(0);
        return res;
    }
}