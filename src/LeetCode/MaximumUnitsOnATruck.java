package LeetCode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        System.out.println(new Solution1710().maximumUnits(new int[][]{
                {1,3},{2,2},{3,1}
                },4));
    }
}
//https://leetcode.com/problems/maximum-units-on-a-truck/submissions/
class Solution1710 {// 7 ms
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1, o2)-> Integer.compare(o2[1], o1[1]));

        int resUnits=0;
        for (int[] boxType : boxTypes) {
            if (truckSize - boxType[0] >= 0) {
                resUnits += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else if (truckSize != 0) {
                resUnits += truckSize * boxType[1];
                truckSize = 0;
            } else {
                return resUnits;
            }
        }
        return resUnits;
    }
}