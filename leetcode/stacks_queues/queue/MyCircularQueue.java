/*
622. Design Circular Queue
Solved
Medium
Topics
Companies
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Implement the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. 
*/

class MyCircularQueue {
    private int[] queue;
    private int head, tail;
    private int len;

    public MyCircularQueue(int k) {
        queue = new int[k];
        head = 0;
        tail = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        tail++;
        if (tail == queue.length) tail = 0;
        queue[tail] = value;
        len++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        if (head == queue.length) head = 0;
        len--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[tail];
    }
    
    public boolean isEmpty() {
        return len == 0;   
    }
    
    public boolean isFull() {
        return len == queue.length;
    }
}