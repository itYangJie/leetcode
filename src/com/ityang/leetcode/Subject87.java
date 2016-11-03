package com.ityang.leetcode;

import java.util.Arrays;

public class Subject87 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isScramble(String s1, String s2) {
		if(s1==null || s2==null || s1.length()!=s2.length())
			return false;
		if(s1.equals(s2))
			return true;
		int len = s1.length();
		
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		if(!new String(chars1).equals(new String(chars2)))
			return false;
		
		for(int i=1;i<len;i++){
			if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
				return true;
			if(isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i),s2.substring(0,len-i)))
				return true;
		}
		return false;
	}
	
}
