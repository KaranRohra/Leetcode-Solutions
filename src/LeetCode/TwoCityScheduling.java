package LeetCode;

import java.util.*;

public class TwoCityScheduling {
    public static void main(String[] args) {
        System.out.println(new Solution1029().twoCitySchedCost(new int[][]{
                {259,770},
                {448,54},
                {926,667},
                {184,139},
                {840,118},
                {577,469}
        }));
    }
}
//https://leetcode.com/problems/two-city-scheduling/submissions/
class Solution1029 {// 1 ms
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;

        Arrays.sort(costs,(o1, o2)->{
            int cost1=o1[0]-o1[1];
            int cost2=o2[0]-o2[1];
            return Integer.compare(cost1,cost2);
        });

        int res=0;
        for(int i=0;i<n;i++){
            if(i<n/2)
                res+=costs[i][0];
            else{
                res+=costs[i][1];
            }
        }
        return res;
    }
}