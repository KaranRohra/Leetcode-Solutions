package Flipkart.Contest_1;

import java.util.*;

public class MaximumSumComponent {
    public static void main(String[] args) {
        System.out.println(new Solution_3().solve(7,4,
                new int[]{10, 25, 5, 15, 5, 20, 0},
                new int[][]{ {1,2} ,{3,4}, {4,5} ,{6,7} }));
    }
}
//https://practice.geeksforgeeks.org/contest-problem/maximum-sum-component/1/
class Solution_3{
    private boolean[] visited;
    public long solve(int v,int E,int[] Values,int[][] Edges){
        visited=new boolean[v+1];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:Edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        long max=0;
        for(int i=1;i<=v;i++){
            if(!visited[i]){
                max=Math.max(max,dfs(i,adj,Values));
            }
        }
        return max;
    }
    private long dfs(int v,ArrayList<ArrayList<Integer>> adj,int[] val){
        visited[v]=true;
        long sum=val[v-1];
        int n=adj.get(v).size();
        for(int i=0;i<n;i++){
            int x=adj.get(v).get(i);
            if(!visited[x]){// Base Case
                sum+=dfs(x,adj,val);
            }
        }
        return sum;
    }
}
