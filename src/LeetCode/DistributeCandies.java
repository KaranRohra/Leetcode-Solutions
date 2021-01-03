package LeetCode;

public class DistributeCandies {
    public static void main(String[] args) {
        Solution575 s=new Solution575();
        System.out.println(s.distributeCandies(new int[]{1,1,2,2,3,3}));
    }
}
class Solution575 {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length,count=0;
        boolean[] pos=new boolean[100001];
        boolean[] neg=new boolean[100001];

        for(int i:candyType){
            if(i<0 && !neg[-i]){
                neg[-i]=true;
                count++;
            }
            else if(i>=0 && !pos[i]){
                pos[i]=true;
                count++;
            }
            if(count==n/2)
                return n/2;
        }
        return count;
    }
}
