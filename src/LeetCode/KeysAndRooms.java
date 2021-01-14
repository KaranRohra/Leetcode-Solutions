package LeetCode;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2,1));
        rooms.add(Arrays.asList(0,3));

        System.out.println(new Solution841().canVisitAllRooms(rooms));
    }
}
//https://leetcode.com/problems/keys-and-rooms/
class Solution841 {// 0 ms
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
        //int n=rooms.get(v).size();
        for(Integer vertex: rooms.get(v)){
            if(!isVisited[vertex]){
                dfs(rooms,vertex);
            }
        }
    }
}