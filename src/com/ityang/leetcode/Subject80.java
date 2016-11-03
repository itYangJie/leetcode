package com.ityang.leetcode;

public class Subject80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
	}

	public static int removeDuplicates(int[] nums) {
		int len;
		if( (len = nums.length) <=2 )
			return len;
		int index = 1;
		
		for(int i=2;i<len;i++){
			if(nums[i]!=nums[index-1]){
				nums[++index] = nums[i];	
			}
				
		}
		return index+1;
	}
}
