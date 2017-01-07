package com.ityang.leetcode;

public class Subject275 {
	 public int hIndex(int[] citations) {
	        if (citations.length == 0)
				return 0;
			if (citations.length == 1)
				return citations[0] >= 1 ? 1 : 0;

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
