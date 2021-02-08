package LeetCode;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] res=new Solution57().insert(new int[][]{
                {1,2},{3,5},{6,7},{8,10},{12,16}
        },new int[]{4,8});
        for(int[] i:res){
            System.out.println(i[0]+" "+i[1]);
        }
    }
}
//https://leetcode.com/problems/insert-interval/
class Solution57 {// 1 ms
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] resInterval = new int[n+1][2];

        int i=0;
        while(i<n && intervals[i][0] <= newInterval[0]){
            resInterval[i][0]=intervals[i][0];
            resInterval[i][1]=intervals[i][1];
            i++;
        }
        resInterval[i][0]=newInterval[0];
        resInterval[i][1]=newInterval[1];
        while(i<n){
            resInterval[i+1][0]=intervals[i][0];
            resInterval[i+1][1]=intervals[i][1];
            i++;
        }
        //return resInterval;

        int newLength=0;
        for(i=0;i<=n;){
            int startValue=resInterval[i][0],endValue=resInterval[i][1];

            while(i<=n && endValue>=resInterval[i][0]){
                if(resInterval[i][1]>endValue){
                    endValue=resInterval[i][1];
                }
                resInterval[i][0]=-1;
                i++;
            }
            resInterval[newLength][0]=startValue;
            resInterval[newLength][1]=endValue;
            newLength++;
        }
        int[][] finalRes=new int[newLength][2];
        for(i=0;i<newLength;i++){
            finalRes[i][0]=resInterval[i][0];
            finalRes[i][1]=resInterval[i][1];
        }
        return finalRes;
    }
}




