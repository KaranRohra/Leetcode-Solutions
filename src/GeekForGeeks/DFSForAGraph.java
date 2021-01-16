package GeekForGeeks;

import java.util.*;

public class DFSForAGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        graph.add(new ArrayList<>(Arrays.asList(1,2,3)));// 0 is connected to 1,2,3
        graph.add(new ArrayList<>());// 1 is not connected to any node or 1 is seek node
        graph.add(new ArrayList<>(Collections.singletonList(4)));// 2 is connected to 4
        graph.add(new ArrayList<>());// 3 is not connected to any node or 3 is seek node
        graph.add(new ArrayList<>());// 4 is not connected to any node or 4 is seek node

        System.out.println(new SolutionDFSForAGraph().dfsForAGraph(5, graph));
    }
}
//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
class SolutionDFSForAGraph {
    private  boolean[] isVisited;
    public ArrayList<Integer> dfsForAGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> res=new ArrayList<>();
        isVisited=new boolean[V];
        dfs(0,adj,res);
        return res;
    }
    private void dfs(int v, ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> res){
        isVisited[v]=true;
        res.add(v);
        int n=adj.get(v).size();
        for(int i=0;i<n;i++){
            if(!isVisited[adj.get(v).get(i)]){
                dfs(adj.get(v).get(i),adj,res);
            }
        }
    }
}