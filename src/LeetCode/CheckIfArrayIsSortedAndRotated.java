package LeetCode;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        System.out.println(new Solution1752().check(new int[]{3,2,1}));
    }
}
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
class Solution1752 {// 1 ms and 5  incorrect submissions
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        System.arraycopy(nums, 0, a, 0, n);
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (isEqual(a, nums, i))
                return true;
        }
        return false;
    }

    private boolean isEqual(int[] a, int[] b, int start) {
        for (int i = 0; i < b.length; i++) {
            if (a[i] != b[start % b.length])
                return false;
            start++;
        }
        return true;
    }
}