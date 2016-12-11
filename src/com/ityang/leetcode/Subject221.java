package com.ityang.leetcode;

import java.util.Stack;

public class Subject221 {

	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][] { 
			{ '1'}, 
			{ '0'}, 
			{ '1'}, 
			{ '1'}, 
			{ '1'}, 
			{ '1'}, 
			{ '0'}, 
		 }));

	}

	public static int maximalSquare(char[][] matrix) {
		int row = matrix.length, column;
		if (row == 0)
			return 0;
		column = matrix[0].length;
		int res = 0;
		int[] heights = new int[column];
		int[][] map = new int[row][column];
		
		for(int i=0;i<column;i++){
			if(matrix[0][i]=='1')
				map[0][i] = 1;
			else
				map[0][i] = 0;
		}
		for (int j = 0; j < column; j++) {
			for (int i = 1; i < row; i++) {
				if(matrix[i][j]=='0')
					map[i][j] = 0;
				else
					map[i][j] = map[i-1][j]+1;
			}
		}

		for (int i = row - 1; i >= 0; i--) {

			for (int j = 0; j < column; j++) 
				heights[j] = map[i][j];
			
			res = Math.max(res, largestSquareArea(heights));
		}

		return res;
	}

	public static int largestSquareArea(int[] heights) {
		int len;
		if ((len = heights.length) == 0)
			return 0;
		
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

				res = Math.max(res, (int) Math.pow(Math.min(high, i - left - 1), 2));
			}

		}

		while (!stack.isEmpty()) {
			high = heights[stack.pop()];
			if (stack.isEmpty())
				left = -1;
			else
				left = stack.peek();
			res = Math.max(res, (int) Math.pow(Math.min(high, len - left - 1), 2));
		}

		return res;
	}
}
