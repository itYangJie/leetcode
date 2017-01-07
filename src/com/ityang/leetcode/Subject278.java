package com.ityang.leetcode;

public class Subject278 {

	boolean isBadVersion(int version) {
		return true;
	}

	public int firstBadVersion(int n) {

		int left = 1, right = n, mid;

		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (isBadVersion(mid))
				right = mid;
			else
				left = mid + 1;
		}
		if (isBadVersion(left))
			return left;

		return right;
	}

}
