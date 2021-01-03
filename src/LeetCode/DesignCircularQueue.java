package LeetCode;

import java.util.Scanner;

public class DesignCircularQueue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of Queue");
        MyCircularQueue obj = new MyCircularQueue(sc.nextInt());
        int option;
        do{
            System.out.println("1: enQueue");
            System.out.println("2: deQueue");
            System.out.println("3: Front");
            System.out.println("4: Rear");
            System.out.println("5: isEmpty");
            System.out.println("6: isFull");
            System.out.println("7: Quit");
            System.out.print("Enter Your option:");
            option= sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter a Data:");
                    boolean param_1 = obj.enQueue(sc.nextInt());
                    if (param_1)
                        System.out.println("enQueue successfull");
                    else
                        System.out.println("enQueue operation failed");
                    break;
                case 2:
                    boolean param_2 = obj.deQueue();
                    if (param_2)
                        System.out.println("deQueue success full");
                    else
                        System.out.println("deQueue operation failed");
                    break;
                case 3:
                    int param_3 = obj.Front();
                    if (param_3 == -1)
                        System.out.println("Front operation failed");
                    else
                        System.out.println(param_3 + " is at Front");
                    break;
                case 4:
                int param_4 = obj.Rear();
                    if (param_4 == -1)
                        System.out.println("Rear operation failed");
                    else
                        System.out.println(param_4 + " is at Rear");
                    break;
                case 5:
                boolean param_5 = obj.isEmpty();
                if(param_5)
                    System.out.println("Queue is Empty");
                else
                    System.out.println("Queue have some elements");
                break;
                case 6:
                boolean param_6 = obj.isFull();
                    if(param_6)
                        System.out.println("Queue is Full");
                    else
                        System.out.println("Queue is not Full");
            }
        }while (option!=7);

    }
}
class MyCircularQueue {
    final int MAX;
    int front,rear,count;
    int[] queueArray;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queueArray=new int[k];
        front=rear=-1;
        count=0;
        MAX=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(count==MAX)
            return false;
        if(rear==-1)
            front++;
        rear++;
        if(rear==MAX)
            rear=0;
        queueArray[rear]=value;
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
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

    /** Get the front item from the queue. */
    public int Front() {
        if(front==-1)
            return -1;
        return queueArray[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(rear==-1)
            return -1;
        return queueArray[rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count==MAX;
    }
}
