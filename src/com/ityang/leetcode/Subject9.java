package com.ityang.leetcode;

public class Subject9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
		boolean isPalindrome = true;
		char[] charArray = String.valueOf(x).toCharArray();
		int len = charArray.length;
		
		int start = 0,end = len-1;
		
		while(start<end){
			if(charArray[start]==charArray[end]){
				start++;end--;
			}else{
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
}
