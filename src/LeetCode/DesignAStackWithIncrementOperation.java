package LeetCode;

public class DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack s=new CustomStack(3);
    }
}
//https://leetcode.com/problems/design-a-stack-with-increment-operation/
class CustomStack {
    private final int maxSize;
    private int top;
    private final int[] a;
    private final int[] inc;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        top=-1;
        a=new int[maxSize];
        inc=new int[maxSize];
    }

    public void push(int x) {
        if(top==maxSize-1)
            return;
        top++;
        a[top]=x;
    }

    public int pop() {
        if(top==-1)
            return -1;
        int val=a[top]+inc[top];
        top--;
        if(top!=-1){
            inc[top]+=inc[top+1];
        }
        inc[top+1]=0;
        return val;
    }

    public void increment(int k, int val) {
        if(top==-1)
            return;
        k--;
        if(k<=top)
            inc[k]+=val;
        else
            inc[top]+=val;
    }
}
