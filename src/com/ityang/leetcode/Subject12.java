package com.ityang.leetcode;

public class Subject12 {

	public static void main(String[] args) {
		System.out.println(intToRoman(3214));
	}

	public static String intToRoman(int num) {
		
		if(num<=0)
			return "";
		String[][] datas = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
	            { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
	            { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
	            { "", "M", "MM", "MMM", "", "", "", "", "", "", "" },
		};
		
		String res = "";
		int bei = 1000;
		for(int i=3;i>=0;i--){
			int index = num/bei;
			res += datas[i][index];
			num = num-bei*index;
			bei /= 10;
		}
		return res;
	}
	
}
