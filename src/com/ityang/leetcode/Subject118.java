package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(5);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if(numRows<=0)
			return res;
		List temp = new ArrayList<Integer>();
		temp.add(1);
		res.add(temp);
		if(numRows == 1)
			return res;
		int[][] number = new int[2][numRows];
		int cur = 0; number[cur][0] = 1;
		for(int i=2;i<=numRows;i++){
			List list = new ArrayList<>();
			list.add(1);
			number[1-cur][0] = 1;
			for(int j=0;j<i-2;j++){
				number[1-cur][j+1] = number[cur][j]+number[cur][j+1];
				list.add(number[1-cur][j+1]);
			}
			number[1-cur][i-1] = 1;
			list.add(1);
			res.add(list);
			cur = 1-cur;
		}
		return res;
	}
}
