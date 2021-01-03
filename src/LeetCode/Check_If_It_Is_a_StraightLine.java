package LeetCode;

public class Check_If_It_Is_a_StraightLine {
    public static void main(String[] args) {
        System.out.println(new Solution1232().checkStraightLine(new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {6,7}
        }));
    }
}
//https://leetcode.com/problems/check-if-it-is-a-straight-line/
class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n=coordinates.length;
        double slope=0;
        boolean x_axis=false;
        for(int i=0;i<n-1;i++){
            int x1=coordinates[i][0];
            int y1=coordinates[i][1];
            int x2=coordinates[i+1][0];
            int y2=coordinates[i+1][1];

            int deltaY=y2-y1;
            int deltaX=x2-x1;
            double slope1=0;
            boolean x_axis1=false;
            if(deltaX==0){
                if(i==0)
                    x_axis=true;
                x_axis1=true;
            }
            else{
                slope1=deltaY*1.0/deltaX;
            }

            if(i==0){
                slope=slope1;
            }
            else if(x_axis && !x_axis1)
                return false;
            else if(slope1!=slope){
                return false;
            }
        }
        return true;
    }
}