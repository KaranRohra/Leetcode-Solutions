package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class ConstructTheRectangle {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Solution492 s = new Solution492();
        System.out.println(Arrays.toString(s.constructRectangle(sc.nextInt())));
    }
}
class Solution492 {
    public int[] constructRectangle(int area) {
        int []a={area,1};
        int diff,i,l,w;
        for(i=1;i<=area/2;i++){
            if(area%i == 0){
                l=area/i;
                w=i;
                if(l*w == area && l>=w){
                    diff=l-w;
                    if(diff < a[0]-a[1]){
                        a[0]=l;
                        a[1]=w;
                    }
                }
            }
        }
        return a;
    }
}