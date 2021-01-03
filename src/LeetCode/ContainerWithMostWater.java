package LeetCode;

import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution11 s = new Solution11();
        int n=sc.nextInt();
        int []a=new int[n];
        for(int i=-0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.maxArea(a));
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int max=0;
        int n=height.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int area=Math.min(height[i],height[j])*(j-i);
                if(area>max)
                    max=area;
            }
        }
        return max;
    }
}
