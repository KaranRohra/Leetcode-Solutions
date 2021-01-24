package LeetCode;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        System.out.println(new Solution1013().canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
    }
}
//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
class Solution1013 {// 2 ms
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        if(sum%3!=0){
            return false;
        }
        System.out.println(sum);
        sum/=3;
        int count=0,currSum=0;
        for (int j : arr) {
            currSum += j;
            if (currSum == sum) {
                count++;
                currSum = 0;
            }
        }
        return currSum==0 && count>=3;
    }
}