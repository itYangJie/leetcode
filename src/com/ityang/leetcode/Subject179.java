package com.ityang.leetcode;

import java.math.BigInteger;

public class Subject179 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Subject179().largestNumber(new int[]{3, 30, 34, 5, 9}));
	}

	public String largestNumber(int[] nums) {
		
		if(nums.length==1)
			return ""+nums[0];
		
		quickSort(nums,0,nums.length-1);
		
		StringBuffer sb = new StringBuffer();
		for(int i=nums.length-1;i>=0;i--)
			sb.append(""+nums[i]);
		String res = sb.toString();
		int firstNotZero = 0;
		for(;firstNotZero<res.length();firstNotZero++){
			if(res.charAt(firstNotZero)!='0')
				break;
		}
		if(firstNotZero==res.length())
			return "0";
		return res.substring(firstNotZero);
	}

	private void quickSort(int[] nums, int low, int high) {
		if(low<high){
			
			int index = partration(nums,low,high);
			quickSort(nums,low,index-1);
			quickSort(nums,index+1,high);
		}
		
	}

	private int partration(int[] nums, int low, int high) {
		
		int mainEle = nums[low];
		while(low<high){
			while(low<high && isGreater(nums[high], mainEle))
				high--;
			nums[low] = nums[high];
			
			while(low<high && !isGreater(nums[low], mainEle))
				low++;
			nums[high] = nums[low];
		}
		nums[low] = mainEle;
		return low;
	}
	
	/**
	 * 如果num1num2>num2num1则返回true
	 * 否则返回false
	 * @param num1
	 * @param num2
	 */
	private boolean isGreater(int num1,int num2){
		BigInteger num1Num2 = new BigInteger(num1+""+num2);
		BigInteger num2Num1 = new BigInteger(num2+""+num1);
		
		if(num1Num2.compareTo(num2Num1)>0 )
			return true;
		return false;
	}
}
