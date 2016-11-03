package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject18 {

	public static void main(String[] args) {
		fourSum(new int[]{1,0,-1,0,-2,2}, 0);

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4)
			return res;
		Arrays.sort(nums);

		int numCount = nums.length, pre1 = Integer.MAX_VALUE, pre2 = Integer.MAX_VALUE;
		for (int i = 0; i < numCount - 3; i++) {
			if (nums[i] == pre1)
				continue;
			for (int j = i + 1; j < numCount - 2; j++) {
				if (nums[j] == pre2)
					continue;
				int start = j+ 1, end = numCount - 1;
				int need = target - nums[i] - nums[j];
				while (start < end) {
					int twoSum = nums[start] + nums[end];
					if (twoSum == need) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						res.add(temp);
						while (start < end && nums[start + 1] == nums[start])
							start++;
						start++;
						while (start < end && nums[end - 1] == nums[end])
							end--;
						end--;

					} else if (twoSum > need) {
						end--;
					} else {
						start++;
					}
				}
				pre2 = nums[j];
			}
			pre2 = Integer.MAX_VALUE;
			pre1 = nums[i];
		}
		return res;
	}
}
