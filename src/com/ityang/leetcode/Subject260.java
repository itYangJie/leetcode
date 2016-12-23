package com.ityang.leetcode;

import java.util.Arrays;

public class Subject260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] singleNumber(int[] nums) {
	    int diff = 0;
	    for(int num: nums){
	        diff^=num;
	    }
	    diff = Integer.highestOneBit(diff);
	    
	    int[] result = new int[2];
	    Arrays.fill(result,0);
	    for(int num: nums){
	        if((diff & num) == 0){
	            result[0] ^= num;
	        }
	        else{
	            result[1] ^= num;
	        }
	    }
	    return result;
	}
}
