package com.ityang.leetcode;

public class Subject123 {
	public static void main(String[] args) {
		System.out.println(maxProfit2(new int[]{0,1,2,0,1,2,8}));
	}

	public static int maxProfit(int[] prices) {
		if(prices.length==0 || prices.length==1)
			return 0;
		int firstTimeMinPrice = prices[0],maxProfit = 0;
		int len = prices.length;
		for(int i=1;i<len;i++){
			int secondTineMaxProfit = 0;
			int secondTimeMinPrice = 0;
			if(i+2<len)
				secondTimeMinPrice = prices[i+1];
			for(int j=i+2;j<len;j++){
				secondTineMaxProfit = Math.max(secondTineMaxProfit,prices[j]-secondTimeMinPrice);
				secondTimeMinPrice = Math.min(secondTimeMinPrice, prices[j]);
			}
			
			maxProfit = Math.max(maxProfit, prices[i]-firstTimeMinPrice+secondTineMaxProfit);
			firstTimeMinPrice = Math.min(firstTimeMinPrice, prices[i]);
		}
		return maxProfit;
	}
	
	public static int maxProfit2(int[] prices) {
		if(prices.length==0 || prices.length==1)
			return 0;
		int len = prices.length;
		int maxPrice[] = new int[len];
		
		maxPrice[len-1] = prices[len-1];
		for (int i = len - 2; i >= 0; i--) {
			maxPrice[i] = Math.max(prices[i], maxPrice[i + 1]);
        }
		int maxProfit = 0,minPrice = prices[0],firstTimeMaxProfit=0;
		for(int i=1;i<len;i++){
			 firstTimeMaxProfit = Math.max(firstTimeMaxProfit,prices[i]-minPrice);
			 minPrice = Math.min(minPrice, prices[i]);
			 
			 maxProfit = Math.max(maxProfit, firstTimeMaxProfit+maxPrice[i]-prices[i]);
		}
		return maxProfit;
	}
}
