package com.ityang.leetcode;

import java.util.Stack;

public class Subject85 {

	public static void main(String[] args) {
		
		System.out.println(maximalRectangle(new char[][]{
			{'1' ,'0', '1' ,'0' ,'0'},
			{'1' ,'0', '1' ,'1' ,'1'},
			{'1' ,'1', '1' ,'1' ,'1'},
			{'1' ,'0', '0' ,'1' ,'0'}
		}));
	}

	public static int maximalRectangle(char[][] matrix) {
		int row = matrix.length,column;
		if(row == 0)
			return 0;
		column = matrix[0].length;
		int res = 0;
		int[] heights = new int[column];
		for(int i=row-1;i>=0;i--){
			
			for(int j=0;j<column;j++){
				int count = 0,k=i;
				while(k>=0 && matrix[k][j]=='1'){
					k--;
					count++;
				}
				heights[j] = count;	
			}
			res = Math.max(res, largestRectangleArea(heights));
		}
		
		return res;
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
