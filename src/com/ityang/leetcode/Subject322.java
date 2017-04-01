package com.ityang.leetcode;

import java.util.Arrays;

public class Subject322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coinChange2(new int[] { 186, 419, 83, 408 }, 6249));
		// System.out.println(coinChange(new int[]{2},3));
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		return helper(coins, amount, new int[amount]);
	}

	private static int helper(int[] coins, int rem, int[] count) { 
		if (rem < 0)
			return -1; // not valid
		if (rem == 0)
			return 0; // completed
		if (count[rem - 1] != 0)
			return count[rem - 1]; // already computed, so reuse
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = helper(coins, rem - coin, count);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}
	public static int coinChange2(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int dp[] =new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		for(int i=1;i<=amount;i++){
			for(int j=0;j<coins.length;j++){
				if(i>=coins[j]){
					dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
				}
			}
		}
		return dp[amount]==amount+1?-1:dp[amount];
	}
}
