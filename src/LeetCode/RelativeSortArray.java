package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class RelativeSortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1122 s = new Solution1122();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int m = sc.nextInt();
        int[] b =  new int[m];
        for(int i=0;i<m;i++)
            b[i]=sc.nextInt();

        System.out.println(Arrays.toString(s.relativeSortArray(a, b)));
    }
}
class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length,k=0;
        int[] a = new int[n];
        int[] c = new int[1001];
        for (int i : arr1) c[i]++;
        for (int i : arr2){
            while (c[i]-->0)
                a[k++]=i;
        }
        for (int i=0;i<1001;i++) {
            if (c[i]!= 0){
                while (c[i]-->0)
                    a[k++]=i;
            }
        }
        return a;
    }
}
//    int n = arr1.length,k=0;
//        int[] a = new int[n];
//        boolean[] p = new boolean[n];
//        Arrays.sort(arr1);
//        for (int value : arr2) {
//            for (int j = 0; j < n; j++) {
//                if (value == arr1[j]) {
//                    p[j]=true;
//                    a[k++] = arr1[j];
//                    if (j != n - 1 && value != arr1[j + 1])
//                        break;
//                }
//            }
//        }
//        for(int i=0;i<n;i++){
//            if(!p[i]){
//                a[k++]=arr1[i];
//            }
//        }
//        return a;
