package LeetCode;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new Solution461().hammingDistance(1,4));
    }
}
//https://leetcode.com/problems/hamming-distance/
class Solution461 {// 0 ms
    public int hammingDistance(int x, int y) {
        int[] bx=new int[32];
        int[] by=new int[32];

        int n=0;
        int i=31;
        while(x!=0){
            bx[i--]=x%2;
            x/=2;
        }
        i=31;
        while(y!=0){
            by[i--]=y%2;
            y/=2;
        }
        for(i=0;i<32;i++){
            if(bx[i]!=by[i])
                n++;
            //System.out.println(bx[i]+" "+by[i]);
        }
        return n;
    }
}