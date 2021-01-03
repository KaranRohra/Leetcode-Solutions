package leetCode;

import java.util.Scanner;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Solution1365 s = new Solution1365();
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        a = s.smallerNumbersThanCurrent(a);
        for(int i : a)
            System.out.print(i+" ");
    }
}
class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] a=new int[101];
        int n=nums.length;
        for (int num : nums) a[num]++;
        for(int i=0;i<n;i++){
            int j=nums[i]-1,count=0;
            while(j>=0){
                count+=a[j];
                j--;
            }
            nums[i]=count;
        }
        return nums;
    }
}
