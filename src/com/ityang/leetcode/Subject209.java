package com.ityang.leetcode;

public class Subject209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSubArrayLen(2, new int[]{2}));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		
		if(nums.length==0)
			return 0;
		// 2 3 1 2 4 3-->0   2 5 6 8 12 15(7)
		int len = nums.length;
		int[] nSum = new int[len+1];
		nSum[0] = 0 ; nSum[1] = nums[0];
		for(int i=2;i<=len;i++){
			nSum[i] = nSum[i-1]+nums[i-1];
		}
		
		int needMin,start,end,res = Integer.MAX_VALUE;
		for(int i=1;i<=len;i++){
			//找到最小的j满足：nSum[j]>=s+nSum[i-1](j>=i)
			needMin = s+nSum[i-1];
			start = i;
			end = len;
			while(start<end){
				int mid = start+(end-start)/2;
				if(nSum[mid]<needMin)
					start = mid+1;
				else
					end = mid;
			}
			if(nSum[start]<needMin)
				res = Math.min(res, Integer.MAX_VALUE);
			else
				res = Math.min(res, start-i+1);
			
		}
		return res==Integer.MAX_VALUE?0:res;
	}

}
