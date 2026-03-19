package com.linkedlist;
import java.util.Stack;
public class ReverseStacks {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(50);
		stack.push(30);
		stack.push(8);
		stack.push(10);
		
		System.out.println("Original Stack: "+ stack);
		reverseStack(stack);
		System.out.println("Reverse Stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}
	
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.empty()) {
			return;
		}
		int top = stack.pop();
		
		reverseStack(stack);
		insertBottom(stack,top);
		
	}
	
	public static void insertBottom(Stack<Integer> stack , int data) {
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		
		int top = stack.pop();
		
		
		insertBottom(stack,data);
		stack.push(top);
		
	}
	
	 public static void sortStack(Stack<Integer> stack) {
	        if (stack.isEmpty()) return;

	        int top = stack.pop();
	        sortStack(stack);
	        insertSorted(stack, top);
	    }

	    public static void insertSorted(Stack<Integer> stack, int data) {
	        if (stack.isEmpty() || stack.peek() <= data) {
	            stack.push(data);
	            return;
	        }

	        int top = stack.pop();
	        insertSorted(stack, data);
	        stack.push(top);
	    }
}
