package com.ityang.leetcode;

public class Subject5 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("baad"));

	}

	public static String longestPalindrome(String s) {
		
		if(s==null || s.length()==0)
			return "";
		
		char[] oldArray = s.toCharArray();
		int oldLen = s.length();
		int newLen = 2*oldLen+1;
		char[] newArray = new char[newLen];
		newArray[0] = '*';
		for(int i=0;i<oldLen;i++){
			newArray[2*i+1] = oldArray[i];
			newArray[2*i+2] = '*';
		}
		int maxCount = 0;
		int maxLengthIndex = 0;
		for(int i=1;i<newLen;i++){
			int count = 1;
			while(i-count>=0 && i+count<newLen && 
					newArray[i-count]==newArray[i+count])
				count++;
			count--;
			if(count>maxCount){
				maxCount = count;
				maxLengthIndex = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=maxLengthIndex-maxCount;i<= (maxLengthIndex+maxCount);i++){
			if(newArray[i] != '*')
				sb.append(newArray[i]);
		}
		
		return sb.toString();
	}
}
