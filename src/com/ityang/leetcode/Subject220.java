package com.ityang.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class Subject220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}
		TreeSet<Integer> values = new TreeSet<>();
		for (int ind = 0; ind < nums.length; ind++) {

			Integer floor = values.floor(nums[ind] + t);
			Integer ceil = values.ceiling(nums[ind] - t);
			if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
				return true;
			}

			values.add(nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind - k]);
			}
		}
		return false;
	}

}
