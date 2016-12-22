package com.ityang.leetcode;

import java.util.Arrays;

public class Subject240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[][] a = new int[][]{ {1,2,4,5}, {2,4,5,8} };
		 * System.out.println(Arrays.binarySearch(a[1], 8));
		 */
		System.out.println(searchMatrix2(new int[][] { { 1, 2, 4, 5 }, { 2, 4, 5, 8 } }, 8));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		int rows = matrix.length;
		if (rows == 0)
			return false;
		int colums = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			if (Arrays.binarySearch(matrix[i], target) >= 0)
				return true;
		}
		return false;
	}

	public static boolean searchMatrix2(int[][] matrix, int target) {

		int rows = matrix.length;
		if (rows == 0)
			return false;
		int colums = matrix[0].length;
		int curRow = 0, curColumn = colums - 1;
		while (curColumn >= 0 && curRow < rows) {
			if (matrix[curRow][curColumn] == target)
				return true;
			else if (matrix[curRow][curColumn] > target) {
				curColumn--;
			} else {
				curRow++;
			}
		}
		return false;
	}
}
