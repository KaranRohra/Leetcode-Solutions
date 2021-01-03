package leetCode;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution169 s = new Solution169();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.majorityElement(a));
    }
}
class Solution169 {
    public int majorityElement(int[] a) {
        Arrays.sort(a);
        return a[a.length/2];
    }
}
// class Solution {
//     public int majorityElement(int[] a) {
//         Set<Integer> x = new HashSet<>();
//         Map<Integer,Integer> b = new HashMap<>();
//         int count,max=0,n,index=0;
//         for(int i : a) x.add(i);
//         for(Integer i : x){
//             count=0;
//             for(int j : a){
//                 if(i==j)
//                     count++;
//             }
//             b.put(i,count);
//         }
//         for(Integer i : x){
//             n=b.get(i);
//             if(max<n) {
//                 max = n;
//                 index=i;
//             }
//         }
//         return index;
//     }
//}