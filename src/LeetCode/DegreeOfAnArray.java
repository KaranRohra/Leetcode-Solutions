package LeetCode;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        System.out.println(new Solution697().findShortestSubArray(new int[]{1,2,2,3,1}));
    }
}
//https://leetcode.com/problems/degree-of-an-array/
class Solution697 {// 4 ms
    public int findShortestSubArray(int[] nums) {
        int[] cnt=new int[50001];
        Length[] se=new Length[50001];

        int n=nums.length;
        int max=0,minLength=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(cnt[nums[i]]==0){
                se[nums[i]]=new Length(i,i);
            }
            else{
                se[nums[i]].end=i;
            }
            cnt[nums[i]]++;
            max=Math.max(cnt[nums[i]],max);
        }

        for (int num : nums) {
            if (cnt[num] == max) {
                int start = se[num].start, end = se[num].end;
                if (end - start + 1 < minLength)
                    minLength = end - start + 1;
                cnt[num] = 0;
            }
        }
        return minLength;
    }
}
class Length{
    int start;
    int end;
    Length(int s,int e){
        start=s;
        end=e;
    }
}