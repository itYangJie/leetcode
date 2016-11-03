package com.ityang.leetcode;

public class Subject35 {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5 ,7,9,10}, 6));

	}

	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || target < nums[0])
			return 0;
		if (target > nums[nums.length - 1])
			return nums.length;
		/*
		 * int index = 0; while(nums[index]<target) index++; return index;
		 */

		int left = 0, right = nums.length-1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (target == nums[mid])
				return mid;
			else if (target > nums[mid])
				left = mid + 1;
			else
				right = mid;

		}
		return left;

	}
}
