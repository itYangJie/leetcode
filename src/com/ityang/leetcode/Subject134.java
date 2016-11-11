package com.ityang.leetcode;

public class Subject134 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		if(len==0)
			return -1;
		
		int sum = 0,startIndex = 0,total = 0;
		for(int i=0;i<len;i++){
			sum = sum+gas[i]-cost[i];
			total = total+gas[i]-cost[i];
			if(sum<0){
				startIndex = i+1;
				sum = 0;
			}
		}
		return total<0?-1:startIndex;
		
	}
}
