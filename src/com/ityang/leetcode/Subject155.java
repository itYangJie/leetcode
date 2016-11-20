package com.ityang.leetcode;

import java.util.Stack;

public class Subject155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Stack<Integer> datasStack,curMinStack;
	public Subject155() {
	      datasStack = new Stack<>();  
	      curMinStack = new Stack<>();  
	}

	public void push(int x) {
		datasStack.push(x);
		if(!curMinStack.isEmpty() && x>=curMinStack.peek()){
			curMinStack.push(curMinStack.peek());
		}else{
			curMinStack.push(x);
		}
	}

	public void pop() {
		datasStack.pop();
		curMinStack.pop();
	}

	public int top() {
		return datasStack.peek();
	}

	public int getMin() {
		return curMinStack.peek();
	}
}
