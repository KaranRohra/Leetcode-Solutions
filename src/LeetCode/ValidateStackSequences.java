package LeetCode;

public class ValidateStackSequences {
    public static void main(String[] args) {
        System.out.println(new Solution946().validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
//https://leetcode.com/problems/validate-stack-sequences/
class Solution946 {// 0 ms
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int top=-1;
        int n=pushed.length;
        int[] stack=new int[n];

        for(int i=0,k=0;k<n;k++){
            stack[++top]=pushed[k];
            while(i<n && top!=-1 && stack[top]==popped[i]){
                top--;
                i++;
            }
        }
        return top==-1;
    }
}