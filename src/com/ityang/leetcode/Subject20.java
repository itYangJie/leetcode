package com.ityang.leetcode;

import java.util.Stack;

public class Subject20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValid(String s) {

		if (s == null || s.length() == 0)
			return false;
		char[] charArray = s.toCharArray();
		int len = charArray.length;

		Stack<Character> stack = new Stack<>();
		stack.push(charArray[0]);
		for (int i = 1; i < len; i++) {
			char c = charArray[i];
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				switch (c) {
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
					break;
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
					break;
				case '}':
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
					break;
				}
			}
		}

		return stack.isEmpty();

	}
}
