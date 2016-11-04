package com.ityang.leetcode;

public class Subject121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
	}

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len==0 || len==1)
			return 0;
		int beforeMin = prices[0],maxProfit=0;
		
		for(int i=1;i<len;i++){
			maxProfit = Math.max(maxProfit, prices[i]-beforeMin);
			beforeMin = Math.min(beforeMin, prices[i]);
		}
		return maxProfit;
	}
}
