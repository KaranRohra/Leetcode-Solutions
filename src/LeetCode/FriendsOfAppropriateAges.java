package LeetCode;

import java.util.Scanner;

public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution825 s = new Solution825();
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(s.numFriendRequests(a));
    }
}
class Solution825 {
    public int numFriendRequests(int[] ages) {
        int request=0;
        int[] count=new int[121];
        for(int val:ages) count[val]++;
        for(int i=1;i<121;i++){
            if(count[i]!=0){
                if(count[i]>1 && i>0.5*i+7)
                    request+=(count[i]-1)*count[i];
                for(int j=i-1;j>=1;j--){
                    if(count[j]!=0){
                        if(j>0.5*i+7)
                            request+=count[j]*count[i];
                    }
                }
            }
        }
        return request;
    }
}