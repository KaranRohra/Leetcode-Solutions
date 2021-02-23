package LeetCode;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1769().minOperations("110")));
    }
}
//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
class Solution1769 {// 2 ms and 0 incorrect submissions
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        char[] str=boxes.toCharArray();

        int[] res=new int[n];
        int rightSum=0,rightCount=0;
        int leftSum=0,leftCount=0;
        for(int i=0;i<n;i++){
            if(str[i]=='1'){
                rightCount++;
                rightSum+=i;
            }
        }

        for(int i=0;i<n;i++){
            res[i]=rightSum+leftSum;

            if(str[i]=='1'){
                if(rightCount==0){
                    rightSum=0;
                }else{
                    rightCount--;
                    leftCount++;
                }
            }
            rightSum-=rightCount;
            leftSum+=leftCount;
        }

        return res;
    }
}
/*
BruteForce
class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int steps=0;
            for(int j=0;j<n;j++){
                if(boxes.charAt(j)=='1'){
                    steps+=Math.abs(j-i);

                }
            }
            res[i]=steps;
        }
        return res;
    }
}
 */

/*
rc: 1
rs: 0

lc: 2
ls: 4

res -> 11, 8, 5, 4, 3, 4
*/