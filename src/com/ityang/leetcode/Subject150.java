package com.ityang.leetcode;

import java.util.Stack;

public class Subject150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int evalRPN(String[] tokens) {
		if(tokens==null || tokens.length==0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int len = tokens.length;
		for(int i=0;i<len;i++){
			int a,b;
			if("+".equals(tokens[i])){
				a = stack.pop();
				b = stack.pop();
				stack.push(b+a);
			}else if("-".equals(tokens[i])){
				a = stack.pop();
				b = stack.pop();
				stack.push(b-a);
			}else if("*".equals(tokens[i])){
				a = stack.pop();
				b = stack.pop();
				stack.push(b*a);
			}else if("/".equals(tokens[i])){
				a = stack.pop();
				b = stack.pop();
				stack.push(b/a);
			}else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
}
