package com.ityang.leetcode;

public class Subject167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
		
		int index1 = 0,index2 = numbers.length-1;
		while(numbers[index1]+numbers[index2]!=target){
			if(numbers[index1]+numbers[index2]>target)
				index2--;
			else
				index1++;
		}
		return new int[]{index1+1,index2+1};
	}
	
}
