package LeetCode;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        System.out.println(new Solution133().cloneGraph(new Node(1)));
    }
}
//https://leetcode.com/problems/clone-graph/submissions/
class Solution133 {// 25 ms
    HashMap<Node,Node> map;
    boolean[] isVisited;
    public Node cloneGraph(Node node) {
        map=new HashMap<>();
        isVisited=new boolean[101];
        fillMap(node);
        isVisited=new boolean[101];
        makeGraph(node);
        return map.get(node);
    }
    private void fillMap(Node node){
        if(node==null)
            return;
        if(isVisited[node.val])
            return;
        isVisited[node.val]=true;
        map.put(node,new Node(node.val));
        //System.out.print(node.val);
        for(int i=0;i<node.neighbors.size();i++){
            Node p=node.neighbors.get(i);
            if(!isVisited[p.val]){
                fillMap(p);
            }
        }
    }
    private void makeGraph(Node node){
        if(node==null)
            return;
        if(isVisited[node.val])
            return;
        isVisited[node.val]=true;

        //System.out.print(node.val);
        for(int i=0;i<node.neighbors.size();i++){
            Node p=node.neighbors.get(i);
            map.get(node).neighbors.add(map.get(p));
            if(!isVisited[p.val]){
                makeGraph(p);
            }
        }
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
}



