package LeetCode;

import java.util.*;

public class FindTheTownJudge {
    public static void main(String[] args) {
        System.out.println(new Solution997().findJudge(4,new int[][]{
                {1,3},
                {1,4},
                {2,3},
                {2,4},
                {4,3}
        }));
    }
}
//https://leetcode.com/problems/find-the-town-judge/
class Solution997 {
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0 && N!=1)
            return -1;

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        boolean[] isNormalPeople=new boolean[N+1];

        for (int[] ints : trust) {
            ArrayList<Integer> x = adjList.get(ints[0]);
            if (x == null) {
                adjList.put(ints[0], new ArrayList<>(Collections.singletonList(ints[1])));
                isNormalPeople[ints[0]] = true;
            } else {
                x.add(ints[1]);
            }
        }

        for(int i=1;i<=N;i++){
            adjList.computeIfAbsent(i, k -> new ArrayList<>());
        }

        outerLoop:
        for(int i=1;i<=N;i++){
            if(!isNormalPeople[i]){
                for (Map.Entry<Integer,ArrayList<Integer>> e: adjList.entrySet()){
                    if(!e.getValue().contains(i) && e.getKey()!=i)
                        continue outerLoop;
                }
                return i;
            }
        }
        return -1;
    }
}
