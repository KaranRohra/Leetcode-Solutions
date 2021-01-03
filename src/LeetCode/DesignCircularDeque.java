package LeetCode;

public class DesignCircularDeque {
    public static void main(String[] args) {

    }
}
class MyCircularDeque {
    final int MAX;
    int front,rear,count;
    int[] queueArray;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queueArray=new int[k];
        front=rear=-1;
        MAX=k;
        count=0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count==MAX)
            return false;
        if(front==-1){
            front++;
            rear++;
        }
        else
            front--;
        if(front==-1)
            front=MAX-1;
        queueArray[front]=value;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count==MAX)
            return false;
        if(front==-1)
            front++;
        rear++;
        if(rear>=MAX)
            rear=0;
        queueArray[rear]=value;
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count==0)
            return false;
        front++;
        if(count==1)
            front=rear=-1;
        if(front==MAX)
            front=0;
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count==0)
            return false;
        rear--;
        if(count==1)
            front=rear=-1;
        else if(rear==-1)
            rear=MAX-1;
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(front==-1)
            return -1;
        return queueArray[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(front==-1)
            return -1;
        return queueArray[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count==MAX;
    }
}