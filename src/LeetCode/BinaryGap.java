package LeetCode;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(new Solution868().binaryGap(22));
    }
}
//https://leetcode.com/problems/binary-gap/
class Solution868 {// 0 ms
    public int binaryGap(int n) {
        int[] str=new int[32];
        int max=0,i=31,length=0;
        while(n!=0){
            str[i--]=n%2;
            n/=2;
        }
        i=0;
        while(i<32 && str[i]==0)
            i++;
        if(i<32){
            length=i;
            i++;
        }
        for(;i<32;i++){
            while(i<32 && str[i]!=1)
                i++;
            if(i==32)
                return max;
            if(i-length>max)
                max=i-length;
            length=i;
        }
        return max;
    }
}