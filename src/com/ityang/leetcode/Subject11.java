package com.ityang.leetcode;

public class Subject11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxArea(int[] height) {
		
		if(height.length<2)
			return -1;
		
		int start = 0,end = height.length-1,res=0,temp=0;
		while(start<end){
			if(height[start]>height[end]){
				temp = height[end]*(end-start);
				end--;
			}else{
				temp = height[start]*(end-start);
				start++;
			}
			
			if(temp>res)
				res = temp;
		}
		return res;
	}
}
