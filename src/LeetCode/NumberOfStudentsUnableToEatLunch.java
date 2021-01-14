package LeetCode;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        System.out.println(new Solution1700().countStudents(
                new int[]{1,1,0,0},
                new int[]{0,1,0,1}
        ));
    }
}
//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
class Solution1700 {// 1 ms
    public int countStudents(int[] students, int[] sandwiches) {
        MyDeque stack=new MyDeque();
        MyDeque queue=new MyDeque();

        int n=students.length;
        for(int i=0;i<n;i++){
            queue.pushBack(students[i]);
            stack.pushBack(sandwiches[i]);
        }

        while(!queue.isEmpty()){
            if(queue.peek()==stack.peek()){
                queue.popFront();
                stack.popFront();
                n--;
            }
            else{
                if(queue.sum==queue.size || queue.sum==0)
                    return n;
                else{
                    int val=queue.peek();
                    queue.popFront();
                    queue.pushBack(val);
                }
            }
        }

        return 0;
    }
}
class MyDeque{
    private final int[] a=new int[150];
    private int front=-1;
    private int rear=-1;
    int size;
    int sum;

    public void pushBack(int val){
        if(front==-1)
            front=rear=0;
        else{
            rear++;
        }
        if(rear==150){
            rear=0;
        }
        a[rear]=val;
        size++;
        sum+=val;
    }

    public void popFront(){
        sum-=a[front];
        front++;
        if(size==1)
            rear=front=-1;
        else if(front==150)
            front=0;
        size--;
    }

    public int peek(){
        return a[front];
    }

    public boolean isEmpty(){
        return front==-1;
    }
}

