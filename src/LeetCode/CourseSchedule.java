package LeetCode;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new Solution207().canFinish(3,new int[][]{
                {0,1},
                {1,0},
                {1,2}
        }));
    }
}
//https://leetcode.com/problems/course-schedule/
class Solution207 {// 2 ms
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            adj.get(i[0]).add(i[1]);
        }

        boolean[] isCompleted=new boolean[numCourses];
        boolean[] isVisited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            boolean ans=dfs(i,adj,isVisited,isCompleted);
            if(!ans){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int v,List<List<Integer>> adj,boolean[] visited,boolean[] isCompleted){
        if(visited[v] && !isCompleted[v]){
            return false;
        }
        else if(visited[v]){
            // System.out.println(v);
            return true;
        }

        visited[v]=true;
        int n=adj.get(v).size();
        for(int i=0;i<n;i++){
            if(!dfs(adj.get(v).get(i),adj,visited,isCompleted)){
                return false;
            }
        }
        isCompleted[v]=true;
        return true;
    }
}