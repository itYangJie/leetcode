package com.ityang.leetcode;

public class Subject190 {

	public static void main(String[] args) {
		
		System.out.println(reverseBits(43261596));
	}

	public static int reverseBits(int n) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toBinaryString(n));
		for(int i=32-sb.length();i>0;i--)
			sb.insert(0,'0');
		String str = sb.reverse().toString();
		int res = 0,cur = 1;
		for(int i=31;i>=0;i--){
			if(str.charAt(i)=='1')
				res += cur;
			cur *=2;
		}
		return res;
	}
}
