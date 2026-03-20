package com.learn;

public class QueueImplement {

    private int[] arr;
    private int front, rear, size, capacity;

    public QueueImplement(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = data;
        size++;
    }

    // Dequeue
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = arr[front];
        front++;
        size--;

        return value;
    }

    // Peek
    public int peek() {
        if (size == 0) return -1;
        return arr[front];
    }

    // Display queue
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

   
    public static void main(String[] args) {

        QueueImplement q = new QueueImplement(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();  

        System.out.println("Dequeued: " + q.dequeue()); 
        q.display();   

        System.out.println("Front element: " + q.peek());

        q.enqueue(40);
        q.enqueue(50);
        q.display();  

        q.enqueue(60); 
        q.display();
    }
}