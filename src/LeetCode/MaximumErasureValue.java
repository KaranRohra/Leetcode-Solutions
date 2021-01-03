package LeetCode;

public class MaximumErasureValue {// VVV IMP
    public static void main(String[] args) {
        System.out.println(new Solution1695().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}
class Solution1695 {// 7ms or 6ms
    public int maximumUniqueSubarray(int[] nums) {
        int sum=0,score;
        int n=nums.length;

        int[] cnt=new int[10002];
        int i=0,j=0;

        cnt[nums[0]]++;
        sum+=nums[0];
        score=sum;
        while(j!=n-1){
            if(cnt[nums[j+1]]==0){
                j++;
                cnt[nums[j]]++;
                sum+=nums[j];
            }
            else{
                sum-=nums[i];
                cnt[nums[i]]--;
                i++;
            }
            score=Math.max(sum,score);
        }
        return score;
    }
}
