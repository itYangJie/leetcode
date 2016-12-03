package com.ityang.leetcode;

public class Subject215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthLargest(new int[] { 7, 6, 5, 4, 3, 2, 1 }, 5));
	}

	// 1 2 3 4 43 34
	public static int findKthLargest(int[] nums, int k) {
		int kMinth = nums.length + 1 - k;
		findKth(nums, 0, nums.length - 1, kMinth);
		return nums[kMinth - 1];
	}

	private static void findKth(int[] nums, int left, int right, int k) {
		if (left < right) {
			int index = partration(nums, left, right);
			if (index == k - 1)
				return;
			else if (index > k - 1)
				findKth(nums, left, index - 1, k);
			else
				findKth(nums, index + 1, right, k);
		}
	}

	private static int partration(int[] nums, int left, int right) {
		int mainEle = nums[left];
		while (left < right) {
			while (left < right && nums[right] > mainEle)
				right--;
			nums[left] = nums[right];
			while (left < right && nums[left] <= mainEle)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = mainEle;
		return left;
	}
}
