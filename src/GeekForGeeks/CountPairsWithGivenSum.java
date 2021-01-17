package GeekForGeeks;

import java.util.*;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        System.out.println(new SolutionCountPairsWithGivenSum().getPairsCount(
                new int[]{1, 5, 7, 1},4,6
        ));
    }
}
//https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#
class SolutionCountPairsWithGivenSum {
    int getPairsCount(int[] a, int n, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:a){
            Integer x=map.get(i);
            map.put(i,x==null?1:x+1);
        }
        for(int i=0;i<n;i++){
            Integer x=map.get(k-a[i]);
            if(x!=null && x>0){
                if(a[i]!=k-a[i]){
                    count+=x;
                }else if(x>1){
                    count+=x-1;
                }
                map.put(a[i],map.get(a[i])-1);
            }
        }
        return count;
    }
}
