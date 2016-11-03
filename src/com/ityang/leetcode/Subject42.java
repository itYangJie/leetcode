package com.ityang.leetcode;

public class Subject42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}

	public static int trap(int[] height) {
		if(height.length==0 || height.length==1)
			return 0;
		int len = height.length;
		int[] leftMax = new int[len],rightMax = new int[len];
		leftMax[0] = 0;
		rightMax[len-1] = 0;
		for(int i=1;i<len;i++){
			leftMax[i] = Math.max(height[i-1],leftMax[i-1]);
			rightMax[len-1-i] = Math.max(rightMax[len-i], height[len-i]);
		}
		int res = 0;
		for(int i=0;i<len;i++){
			int temp = Math.min(leftMax[i], rightMax[i])-height[i];
			if(temp>0)
				res +=temp;
		}
		return res;
	}
}
