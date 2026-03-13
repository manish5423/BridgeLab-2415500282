package com.linkedlist;

public class StackWithLinkedlist {

    // Node class
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node top = null; // stack top

    // PUSH operation
    public void push(int val) {

        Node newNode = new Node(val);

        if (top == null) {
            top = newNode;
        } 
        else {
            newNode.next = top;
            top = newNode;
        }

        System.out.println(val + " pushed into stack");
    }

    // POP operation
    public void pop() {

        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println(top.val + " popped");
        top = top.next;
    }

    // DISPLAY stack
    public void display() {

        Node temp = top;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Main method
    public static void main(String[] args) {

        StackWithLinkedlist s = new StackWithLinkedlist();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        s.pop();

        s.display();
    }
}