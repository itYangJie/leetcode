package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject52 {

	public static void main(String[] args) {
		System.out.println(totalNQueens(4));

	}

	public static int totalNQueens(int n) {

		if (n <= 3)
			return 0;
		int[] data = new int[n];

		for (int j = 0; j < n; j++) {
			data[j] = j;
		}

		int res = dfs(data, 0, n,0);
		return res;
	}

	private static int dfs(int[] data, int index, int n,int cur) {

		if (index == n) {
			boolean isValidata = isValidate(data, n);
			if (isValidata) 
				return cur+1;
		}
		for (int i = index; i < n; i++) {

			swap(data, i, index);

			cur = dfs(data, index + 1, n,cur);
			swap(data, i, index);
		}
		return cur;
	}

	

	private static void swap(int[] data, int i, int index) {
		int temp = data[i];
		data[i] = data[index];
		data[index] = temp;
	}

	private static boolean isValidate(int[] data, int n) {

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (i - j == data[i] - data[j] || i - j == data[j] - data[i]) {
					return false;
				}

			}
		}
		return true;
	}
}
