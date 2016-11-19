package com.ityang.leetcode;

public class Subject152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProduct(int[] nums) {
		
		if(nums.length==1)
			return nums[0];
		int len = nums.length,max = nums[0],tempMax,tempMin;
		int[] dpMax = new int[len],dpMin = new int[len];
		dpMax[0] = dpMin[0] =  nums[0];
		for(int i=1;i<len;i++){
			if(nums[i]==0){
				tempMax = tempMin = 0;
			}else{
				tempMax = Math.max(Math.max(nums[i], nums[i]*dpMax[i-1]),nums[i]*dpMin[i-1]);
				tempMin = Math.min(Math.min(nums[i], nums[i]*dpMax[i-1]),nums[i]*dpMin[i-1]);
			}
			dpMax[i] = tempMax;
			dpMin[i] = tempMin;
			max = Math.max(max, dpMax[i]);
		}
		return max;
		
	}
}
