package LeetCode;

import java.util.*;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public static void main(String[] args) {
        int[] res=new Solution1519().countSubTrees(7,
                new int[][]{
                        {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        },"abaedcd");
        for (int i:res)
            System.out.print(i+" ");
    }
}
//https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
class Solution1519 {// 84 ms
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] res=new int[n];
        dfs(0,adjList,new boolean[n],labels.toCharArray(),res);
        return res;
    }
    private int[] dfs(int vertex,List<List<Integer>> adjList,boolean[] isVisited,char[] lab,int[] res){
        List<Integer> list=adjList.get(vertex);
        int n=list==null ? 0 : list.size();
        int[] cnt=new int[26];

        isVisited[vertex]=true;
        for(int i=0;i<n;i++){
            int v=list.get(i);
            if(!isVisited[v])
                cnt=add(dfs(v,adjList,isVisited,lab,res),cnt);
        }
        cnt[lab[vertex]-'a']++;
        res[vertex]=cnt[lab[vertex]-'a'];
        return cnt;
    }
    private int[] add(int[] a,int[] b){
        for(int i=0;i<26;i++){
            a[i]=a[i]+b[i];
        }
        return a;
    }
}