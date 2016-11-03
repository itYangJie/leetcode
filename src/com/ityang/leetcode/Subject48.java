package com.ityang.leetcode;

public class Subject48 {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		rotate(matrix);
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
		

	}

	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		if(len<=1)
			return ;
		int temp;
		for(int i=0;i<len-1;i++)
			for(int j=0;j<len-i-1;j++){
				temp = matrix[len-1-j][len-1-i];
				matrix[len-1-j][len-1-i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		
		for(int i=len/2-1;i>=0;i--){
			for(int j=0;j<len;j++){
				temp = matrix[len-1-i][j];
				matrix[len-1-i][j] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		
	}
}
