package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRow(1);
	}

	 public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		if(rowIndex<0)
			return res;
		
		if(rowIndex == 0){
			res.add(1);
			return res;
		}
		int[][] number = new int[2][rowIndex+1];
		int cur = 0; number[cur][0] = 1;
		for(int i=1;i<=rowIndex;i++){
			number[1-cur][0] = 1;
			for(int j=0;j<=i-2;j++){
				number[1-cur][j+1] = number[cur][j]+number[cur][j+1];
				
			}
			number[1-cur][i] = 1;
			
			cur = 1-cur;
		}
		for(int i=0;i<=rowIndex;i++){
			res.add(number[cur][i]);
		}
		return res;
	}
}
