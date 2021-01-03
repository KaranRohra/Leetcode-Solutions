package Flipkart.Contest_1;

import java.util.*;

public class MaximumSumComponent {
    public static void main(String[] args) {
        System.out.println(new Solution_3().solve(7,4,
                new int[]{10, 25, 5, 15, 5, 20, 0},
                new int[][]{ {1,2} ,{3,4}, {4,5} ,{6,7} }));
    }
}
class Solution_3{
    boolean[] visited;
    public long solve(int V,int E,int[] Values,int[][] Edges){
        visited=new boolean[V+1];
        HashMap<Integer,ArrayList<Integer>> adjList=new HashMap<>();
        int n = Edges.length;
        for (int[] edge : Edges) {
            ArrayList<Integer> x = adjList.get(edge[0]);
            if (x == null)
                adjList.put(edge[0], new ArrayList<>(Collections.singletonList(edge[1])));
            else
                x.add(edge[1]);
        }

        long sum=0,max=0;

        for(Map.Entry<Integer,ArrayList<Integer>> e: adjList.entrySet()){
            int key=e.getKey();
            if(!visited[key]){
                max=Math.max(sum,max);
                sum=0;
            }
            if(!visited[key])
                sum+=Values[e.getKey()-1];
            visited[key]=true;
            for(Integer num: e.getValue()){
                if(!visited[num])
                    sum+=Values[num-1];
                visited[num]=true;
            }
        }
        return max;
    }
}
