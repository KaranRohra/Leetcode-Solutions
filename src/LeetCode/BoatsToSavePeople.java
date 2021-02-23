package LeetCode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        System.out.println(new Solution881().numRescueBoats(new int[]{
                3,2,2,1
        },3));
    }
}
//https://leetcode.com/problems/boats-to-save-people/
class Solution881 { // 14 ms
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int c=0;
        while(i<=j){
            if(people[i]+people[j]>limit){
                j--;
            }
            else{
                i++;
                j--;
            }
            c++;
        }
        return c;
    }
}