package leetCode;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution349 s = new Solution349();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();

        int m = sc.nextInt();
        int[] b =  new int[m];
        for(int i=0;i<m;i++)
            b[i]=sc.nextInt();
        System.out.println(Arrays.toString(s.intersection(a, b)));
    }
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        int n = nums1.length,m = nums2.length,i,y;
        for(i=0;i<n;i++)
            a.add(nums1[i]);
        for(i=0;i<m;i++)
            b.add(nums2[i]);
        for (Integer integer : a) {
            y = integer;
            if (b.contains(y))
                inter.add(y);
        }
        Iterator<Integer> e = inter.iterator();
        i=0;
        int[] result = new int[inter.size()];
        while (e.hasNext())
            result[i++]=e.next();
        return result;
    }
}
