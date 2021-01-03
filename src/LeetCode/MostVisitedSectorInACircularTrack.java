package leetCode;

import java.util.*;

public class MostVisitedSectorInACircularTrack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1560 s = new Solution1560();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.mostVisited(sc.nextInt(),a));
    }
}
class Solution1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> a = new ArrayList<>();
        int m = rounds.length,x,max=0;
        int[] count=new int[n+1];
        for(int i=0;i<m-1;i++){
            x=i==0?rounds[i] : rounds[i]+1;
            if(rounds[i]<rounds[i+1]){
                for(int j=x;j<=rounds[i+1];j++)
                    count[j]++;
            }
            else{
                for(int j=x;j<=n;j++)
                    count[j]++;
                for(int j=rounds[i+1];j>=1;j--)
                    count[j]++;
            }
        }
        for(int i:count)
            if(i>max)
                max=i;
        for(int i=1;i<=n;i++){
            if(max==count[i])
                a.add(i);
        }
        return a;
    }
}