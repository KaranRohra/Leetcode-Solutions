package LeetCode;

import java.util.*;

public class MaximumScoreFromRemovingStones {
    public static void main(String[] args) {
        System.out.println(new Solution1753().maximumScore(2,4,6));
    }
}
//https://leetcode.com/problems/maximum-score-from-removing-stones/submissions/
class Solution1753 {// 16 ms and 2 incorrect submission
    public int maximumScore(int a, int b, int c) {
        int[] arr={a,b,c};
        int res=0;
        while(isTwoValuesAreZero(arr)){
            Arrays.sort(arr);
            if(arr[0]!=0)
                arr[0]--;
            else
                arr[1]--;
            arr[2]--;
            res++;
        }
        return res;
    }
    private boolean isTwoValuesAreZero(int[] arr){
        int count=0;
        for(int i=0;i<3;i++){
            if(arr[i]==0){
                count++;
            }
        }
        return count<=1;
    }
}