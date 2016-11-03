package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject89 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> grayCode(int n) {
		int totalCount = 1<<n;
		List<Integer> res = new ArrayList<>(); 
		for(int i=0;i<totalCount;i++)
			res.add(i^(i>>1));
		return res;
	}
}
