package com.ityang.leetcode;

public class Subject65 {

	public static void main(String[] args) {
		System.out.println(isNumber(" -. "));

	}

	public static boolean isNumber(String s) {
		if(s==null || s.length()==0)
			return false;
		s = s.trim();
		if(s.equals("."))
			return false;
		if(s.matches("[+-]?\\d+"))
			return true;
		if(s.matches("[+-]?((\\d*\\.\\d+)|(\\d+\\.\\d*))"))
			return true;
		if(s.matches("[+-]?\\d+e[+-]?\\d+"))
			return true;
		if(s.matches("[+-]?((\\d*\\.\\d+)|(\\d+\\.\\d*))e[+-]?\\d+"))
			return true;
		return false;
		
	}
}
