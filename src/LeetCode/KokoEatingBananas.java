package LeetCode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(new Solution875().minEatingSpeed(
                new int[]{
                        3,6,7,11
                },8
        ));
    }
}
//https://leetcode.com/problems/koko-eating-bananas/submissions/
class Solution875 {// 14 ms
    public int minEatingSpeed(int[] piles, int H) {
        int low=1,high=0,k=0,mid;

        for(int i:piles)
            if(i>high)
                high=i;

        while(low<=high){
            mid=(low+high)/2;

            if( isAllBananaEatenInTime(piles,H,mid) ){
                high=mid-1;
                k=mid;
            }
            else{
                low=mid+1;
            }
        }
        return k;
    }
    public boolean isAllBananaEatenInTime(int[] p, int h, int k){
        int sumH=0;
        for(int i:p){
            sumH+=i/k;
            if(i%k!=0)
                sumH++;
        }
        return sumH<=h;
    }
}

