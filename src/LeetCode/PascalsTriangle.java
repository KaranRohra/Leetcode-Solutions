package leetCode;

import java.util.*;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution118 s = new Solution118();
        System.out.println(s.generate(sc.nextInt()));
    }
}
class Solution118 {// 0ms
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> a = new ArrayList<>();
        int[][] b=new int[n][];
        for(int i=0;i<n;i++){
            List<Integer> x = new ArrayList<>();
            b[i]=new int[i+1];
            b[i][0]=1;
            for(int j=1;j<i;j++){
                b[i][j]=b[i-1][j-1]+b[i-1][j];
            }
            b[i][i]=1;
            for(int j=0;j<=i;j++)
                x.add(b[i][j]);
            a.add(x);
        }
        return a;
    }
}