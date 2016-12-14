package com.ityang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Subject225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	private Queue<Integer> queue = new LinkedList<>();
	private Queue<Integer> temp = new LinkedList<>();
	 // Push element x onto stack.
    public void push(int x) {
        
    	while(!queue.isEmpty()){
    		temp.add(queue.poll());
    	}
    	queue.add(x);
    	queue.addAll(temp);
    	temp.clear();
    }

    // Removes the element on top of the stack.
    public void pop() {
         queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
