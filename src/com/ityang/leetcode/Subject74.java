package com.ityang.leetcode;

public class Subject74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchMatrix(new int[][]{
			{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		}, 50));
		
		
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		int rowNum = matrix.length;
		int column = matrix[0].length;
		
		int start = 0,end = rowNum*column-1;
		
		while(start<=end){
			
			int mid = start+(end-start)/2;
			int rowIndex = mid/column;
			int columnIndex = mid%column;
			
			if(matrix[rowIndex][columnIndex]==target){
				return true;
			}else if(matrix[rowIndex][columnIndex]>target){
				end = mid-1;
			}else{
				start = mid+1;
			}
			
		}
		return false;
		
	}
}
