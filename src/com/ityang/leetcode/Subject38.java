package com.ityang.leetcode;

public class Subject38 {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));

	}

	public static String countAndSay(int n) {
		if(n<=1)
			return "1";
		String preStr = countAndSay(n-1);
		char[] charArray = preStr.toCharArray();
		
		int len = charArray.length;
		char preChar = charArray[0];
		
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(int i=1;i<len;i++){
			if(charArray[i]==preChar){
				count++;
				continue;
			}
			sb.append(String.valueOf(count)+preChar);
			preChar = charArray[i];
			count = 1;
		}
		sb.append(String.valueOf(count)+preChar);
		return sb.toString();
	}
}
