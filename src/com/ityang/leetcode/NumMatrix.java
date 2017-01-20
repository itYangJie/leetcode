package com.ityang.leetcode;

public class NumMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumMatrix numMatrix = new NumMatrix(new int[][]{
			{3, 0, 1, 4, 2},
			{5, 6, 3, 2, 1},
			{1, 2, 0, 1, 5},
			{4, 1, 0, 1, 7},
			{1, 0, 3, 0, 5}
			
		});
		System.out.println(numMatrix.sumRegion(0, 1, 2, 2));
	}

	private int[][] sum;

	public NumMatrix(int[][] matrix) {
		int cows = matrix.length, columns = matrix[0].length;
		sum = new int[cows][columns];
		sum[0][0] = matrix[0][0];
		for (int i = 1; i < cows; i++) {
			sum[i][0] = sum[i - 1][0] + matrix[i][0];
		}
		for (int i = 1; i < columns; i++) {
			sum[0][i] = sum[0][i - 1] + matrix[0][i];
		}
		for (int i = 1; i < cows; i++) {
			for (int j = 1; j < columns; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(row1>=1 && col1>=1){
			return sum[row2][col2] - (sum[row2][col1 - 1] + sum[row1 - 1][col2] - sum[row1 - 1][col1 - 1]);
		}
		if(col1>=1){
			return sum[row2][col2] - sum[row2][col1 - 1];
		}
		if(row1>=1)
			return sum[row2][col2] - sum[row1 - 1][col2];
		return sum[row2][col2];
	}
}
