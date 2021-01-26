package LeetCode;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        System.out.println(new Solution849().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
}
//https://leetcode.com/problems/maximize-distance-to-closest-person/
class Solution849 {// 1 ms

    public int maxDistToClosest(int[] seats) {
        int n = seats.length, start = 0, end = n - 1;
        int res = 0;
        while (start < n && seats[start] == 0) {
            start++;
        }
        while (end >= start && seats[end] == 0) {
            end--;
        }
        for (int i = start; i <= end; i++) {
            int s = i;
            while (i <= end && seats[i] == 0) {
                i++;
            }
            if (s != i && i - s > res) {
                res = i - s;
            }
        }
        res = res % 2 == 0 ? res / 2 : res / 2 + 1;
        return Math.max(res, Math.max(start, n - end - 1));
    }
}