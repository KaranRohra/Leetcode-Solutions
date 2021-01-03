package leetCode;

import java.util.*;

public class HeightChecker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution1051 s = new Solution1051();
        int n =sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.heightChecker(a));
    }
}
class Solution1051 {
    public int heightChecker(int[] heights) {
        int[] orig = new int[heights.length];
        System.arraycopy(heights, 0, orig, 0, heights.length);

        Arrays.sort(heights);

        int res = 0;
        for (int i=0; i<heights.length; i++) {
            if (orig[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}