package LeetCode;

import java.util.*;

public class DiagonalTraverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution498().findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
    }
}
//https://leetcode.com/problems/diagonal-traverse/submissions/
class Solution498 {// 2 ms
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int n = matrix.length, m = matrix[0].length;
        int[] ans = new int[n * m];

        int k = 0, row = 0, col = 0, startCol = 0, startRow = 0, direction = 0;// 0 direction indicates up and 1 indicates down
        while (k < n * m) {

            if (direction == 0) {
                for (int i = row, j = startCol; i >= 0 && j < m; i--, j++) {
                    ans[k++] = matrix[i][j];
                }
                direction = 1;
            } else {
                for (int i = startRow, j = col; i < n && j >= 0; i++, j--) {
                    ans[k++] = matrix[i][j];
                }
                direction = 0;
            }

            if (row != n - 1)
                row++;
            else
                startCol++;
            if (col != m - 1)
                col++;
            else
                startRow++;
        }
        return ans;
    }
}
