package leetCode;

import java.util.*;

public class SortArrayByParityII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution922 s = new Solution922();
        int n =sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(Arrays.toString(s.sortArrayByParityII(a)));
    }
}
class Solution922 {
    public int[] sortArrayByParityII(int[] a) {
        int x=0,y=1;
        int []res = new int[a.length];
        for (int value : a) {
            if (value % 2 == 0) {
                res[x]=value;
                x+=2;
            }
            else {
                res[y]=value;
                y+=2;
            }
        }
        return res;
    }
}
