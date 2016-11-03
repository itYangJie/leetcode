package com.ityang.leetcode;

import java.util.HashMap;

public class Subject3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] chars = s.toCharArray();
		int left = 0, right = 0, length = s.length();
		if (length == 0) {
			return 0;
		}
		int res = 1;
		while (true) {

			while (right < length && (map.get(chars[right]) == null)) {
				map.put(chars[right], right);
				right++;
			}
			res = Math.max(res, right - left);
			if (right == length) {
				break;
			}

			map.remove(chars[left++]);

		}
		return res;
	}
}
