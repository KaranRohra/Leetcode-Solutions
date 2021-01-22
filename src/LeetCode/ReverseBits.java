package LeetCode;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new Solution190().reverseBits(43261596));
    }
}
class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==Integer.MIN_VALUE){
            return 1;
        }
        int[] binary = decimalToBinary(n);

        if(binary[31]==0){
            return binaryToDecimal(binary);
        }
        else{
            for(int i=0;i<32;i++){
                binary[i] = binary[i] == 0 ? 1 : 0;
            }
            return ~binaryToDecimal(binary);
        }
    }

    private int[] decimalToBinary(int n) {
        int[] binary = new int[32];
        int i = 31;
        int res = n;
        n = n < 0 ? -n : n;
        while (n != 0) {
            binary[i--] = n % 2;
            n /= 2;
        }
        if (res >= 0)
            return binary;

        //2's Complement
        i = 31;
        while (i >= 0 && binary[i] == 0)
            i--;
        i--;
        while (i >= 0) {
            binary[i] = binary[i] == 0 ? 1 : 0;
            i--;
        }
        return binary;
    }

    private int binaryToDecimal(int[] binary){
        int n=0;
        for(int i=0;i<32;i++){
            if(binary[i]==1)
                n+=Math.pow(2,i);
        }
        return n;
    }
}


