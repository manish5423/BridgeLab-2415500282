package com.linkedlist;

import java.util.Stack;

public class ReverseLinkedlist {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // insert node
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // reverse using stack
    public void reverse() {

        Stack<Integer> stack = new Stack<>();

        Node temp = head;

        // push all elements
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // pop and replace
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
    }

    // display list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        ReverseLinkedlist list = new ReverseLinkedlist();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.println("Original List:");
        list.display();

        list.reverse();

        System.out.println("Reversed List:");
        list.display();
    }
}