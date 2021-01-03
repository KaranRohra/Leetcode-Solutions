package LeetCode;

import java.util.*;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution989 s = new Solution989();
        int n=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.addToArrayForm(a,sc.nextInt()));
    }
}
class Solution989 {
    public List<Integer> addToArrayForm(int[] a, int k) {
        int n=a.length,m=0,temp=k,i,carry=0,x,y,j;
        List<Integer> result=new ArrayList<>();
        while(temp!=0){
            m++;
            temp/=10;
        }
        int[] b = new int[m];
        temp=k;
        i=m-1;
        while(temp!=0){
            b[i--]=temp%10;
            temp/=10;
        }
        for(i=n-1,j=m-1;i>=0 && j>=0;i--,j--){
            x=a[i]+b[j]+carry;
            carry=x/10;
            result.add(0,x%10);
        }
        for(;i>=0;i--){
            x=a[i]+carry;
            carry=x/10;
            result.add(0,x%10);
        }
        for(;j>=0;j--){
            x=b[j]+carry;
            carry=x/10;
            result.add(0,x%10);
        }
        return result;
    }
}