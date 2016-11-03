package com.ityang.leetcode;

import java.util.Stack;

public class Subject84 {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));

	}

	public static int largestRectangleArea(int[] heights) {
		int len;
		if ((len = heights.length) == 0)
			return 0;
		if (len == 1)
			return heights[0];
		Stack<Integer> stack = new Stack<>();
		int res = 0, high, left;
		for (int i = 0; i < len;) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
				stack.push(i++);
			else {
				high = heights[stack.pop()];
				if (stack.isEmpty())
					left = -1;
				else
					left = stack.peek();

				res = Math.max(res, high * (i - left - 1));
			}

		}

		while (!stack.isEmpty()) {
			high = heights[stack.pop()];
			if (stack.isEmpty())
				left = -1;
			else
				left = stack.peek();

			res = Math.max(res, high * (len - left - 1));
		}

		return res;
	}

}
