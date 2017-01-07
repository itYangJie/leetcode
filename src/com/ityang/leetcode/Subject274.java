package com.ityang.leetcode;

import java.util.Arrays;

public class Subject274 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hIndex(new int[] { 0, 0 }));
	}

	// 0 1 3 5 6
	public static int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		if (citations.length == 1)
			return citations[0] >= 1 ? 1 : 0;
		Arrays.sort(citations);
		int left = 0, right = citations.length - 1, mid;
		while (left < right - 1) {
			mid = left + (right - left) / 2;
			if (citations[mid] >= citations.length - mid)
				right = mid;
			else
				left = mid + 1;
		}
		if (citations[left] >= citations.length - left)
			return citations.length - left;
		
		if (citations[right] >= citations.length - right)
			return citations.length - right;
		return 0;

	}
}
