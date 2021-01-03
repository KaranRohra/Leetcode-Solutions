package leetCode;

import java.util.*;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution728 s = new Solution728();
        System.out.println(s.selfDividingNumbers(sc.nextInt(),sc.nextInt()));
    }
}
class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> r = new ArrayList<>();
        int n;
        loop1:
        for (int i = left; i <= right; i++) {
            n = i;
            while (n != 0) {
                if (n%10==0 || i % (n % 10) != 0)
                    continue loop1;
                n /= 10;
            }
            r.add(i);
        }
        return r;
    }
}
//class Solution {
//    public List<Integer> selfDividingNumbers(int left, int right) {
//        ArrayList<Integer> r = new ArrayList<>();
//        int n;
//        loop1:for(int i=left;i<=right;i++){
//            if(isCheckZero(i)){
//                n=i;
//                while(n!=0){
//                    if(i%(n%10)!=0)
//                        continue loop1;
//                    n/=10;
//                }
//                r.add(i);
//            }
//        }
//        return r;
//    }
//    public boolean isCheckZero(int n){
//        while(n!=0){
//            if(n%10==0)
//                return false;
//            n/=10;
//        }
//        return true;
//    }
//}