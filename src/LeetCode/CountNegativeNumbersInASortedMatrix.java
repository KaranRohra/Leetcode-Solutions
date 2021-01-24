package LeetCode;

public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        System.out.println(new Solution1351().countNegatives(new int[][]{
                {4,3,2,-1},{3,2,1,-1}
        }));
    }
}
//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
class Solution1351 {// 0 ms
    public int countNegatives(int[][] grid) {
        int count=0;
        for (int[] ints : grid) {
            count += binary(ints);
        }
        return count;
    }
    public int binary(int[] grid){
        int count=0,i=grid.length-1;
        while(i>=0 && grid[i]<0){
            count++;
            i--;
        }
        return count;
    }
}