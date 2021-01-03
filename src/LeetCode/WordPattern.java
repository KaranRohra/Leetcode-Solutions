package LeetCode;

import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution290 s = new Solution290();
        System.out.println(s.wordPattern(sc.nextLine(),sc.nextLine()));
    }
}
class Solution290 {
    public boolean wordPattern(String p, String w) {
        int n = p.length(),k=1;
        String[] words = w.split(" ");
        char[] str = p.toCharArray();
        Map<Character,String> a = new HashMap<>();
        if(n != words.length)
            return false;
        a.put(str[0],words[0]);
        boolean x;
        for(int i=1;i<n;i++) {
            x = a.containsKey(str[i]);
            if(x && !a.get(str[i]).equals(words[i]))
                return false;
            if(!x) {
                a.put(p.charAt(i), words[i]);
                str[k++]=p.charAt(i);
            }
        }

        for(int i=0;i<k;i++){
            for(int j=i+1;j<k;j++){
                if(a.get(str[i]).equals(a.get(str[j])))
                    return false;
            }
        }
        return true;
    }
}
