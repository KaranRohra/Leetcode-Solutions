package leetCode;

import java.util.*;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1408 s = new Solution1408();
        int n = sc.nextInt();
        String[] a = new String[n];
        for(int i=0;i<n;i++)
            a[i] = sc.next();
        System.out.println(s.stringMatching(a));
    }
}
class Solution1408 {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        Set<String> a = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && words[i].contains(words[j])){
                    a.add(words[j]);
                }
            }
        }
        return new ArrayList<>(a);
    }
}
