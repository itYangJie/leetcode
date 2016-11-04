package com.ityang.leetcode;

public class Subject122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
	}
}
