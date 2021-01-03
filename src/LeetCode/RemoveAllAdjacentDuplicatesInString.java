package leetCode;

import java.util.*;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution1047 s = new Solution1047();
        System.out.println(s.removeDuplicates(sc.next()));
    }
}
class Solution1047 {// 24ms
    public String removeDuplicates(String s) {
        char[] str=s.toCharArray();
        Stack<Character> a=new Stack<>();
        int n=str.length;
        if(n!=0) {
            for (char c : str) {
                if (a.empty() || a.peek() != c)
                    a.push(c);
                else
                    a.pop();
            }
        }
        char[] result=new char[n=a.size()];
        for(int i=n-1;i>=0;i--){
            result[i]=a.peek();
            a.pop();
        }
        return String.valueOf(result);
    }
}
//class Solution { 515ms
//    public String removeDuplicates(String s) {
//        char[] str = s.toCharArray();
//        char[] result=new char[str.length];
//        int n=str.length;
//        for(int i=0;i<n;){
//            char x=str[i];
//            int index=i,count=0;
//            while(i<n && str[i]==x) {
//                i++;
//                count++;
//            }
//            if(count!=1) {
//                if (count % 2 != 0) {
//                    index++;
//                    count--;
//                }
//                System.arraycopy(str,i,str,index,n-i);
//                i = 0;
//                n -= count;
//            }
//        }
//        return String.valueOf(str).substring(0,n);
//    }
//}