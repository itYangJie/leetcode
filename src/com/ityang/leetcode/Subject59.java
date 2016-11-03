package com.ityang.leetcode;

public class Subject59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateMatrix(3);
	}

	public static int[][] generateMatrix(int n) {
		
		int[][] data = new int[n][n];
		if (n <= 0)
			return data;
		int layer = 0, count = 1;
		while (layer <= (n - 1) / 2) {
			// add the top
			for (int i = layer; i < n - layer; i++) {

				data[layer][i] = count++;
			}
			// add right side
			for (int i = layer + 1; i < n - layer; i++) {
				data[i][n - layer - 1] = count++;
			}
			if (layer < n / 2) {
				// add bottom
				for (int i = n - 1 - layer - 1; i >= layer; i--) {
					data[n - layer - 1][i] = count++;
				}
				// add right side
				for (int i = n - 1 - layer - 1; i >= layer + 1; i--) {
					data[i][layer] = count++;
				}
			}

			layer++;
		}
		return data;
	}
}
