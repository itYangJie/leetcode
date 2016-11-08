package com.ityang.leetcode;

public class Subject125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
		if(s==null || s.length()==0 || s.length()==1)
			return true;
		int len = s.length(),start = 0,end = len-1;
		while(start<end){
			
			while(start<end && !( (s.charAt(start)>='0' && s.charAt(start)<='9') || 
					(s.charAt(start)>='a' && s.charAt(start)<='z') || 
					(s.charAt(start)>='A' && s.charAt(start)<='Z') ))
				start++;
			
			while(start<end && !( (s.charAt(end)>='0' && s.charAt(end)<='9') || 
					(s.charAt(end)>='a' && s.charAt(end)<='z') || 
					(s.charAt(end)>='A' && s.charAt(end)<='Z') ))
				end--;
			if(!(s.substring(start, start+1).equalsIgnoreCase(s.substring(end, end+1))))
				return false;
			
			start++;
			end--;
		}
		return true;
	}
}
