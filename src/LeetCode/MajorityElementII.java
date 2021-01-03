package leetCode;

import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution229 s = new Solution229();
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.majorityElement(a));
    }
}
class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> a=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0,n=nums.length;i<n;){
            int x=nums[i],count=0;
            while(i<n && nums[i]==x){
                count++;
                i++;
            }
            if(count>n/3)
                a.add(x);
        }
        return a;
    }
}