package com.ityang.leetcode;

public class Subject67 {

	public static void main(String[] args) {
		
		System.out.println(addBinary("11", "1"));
	}

	public static String addBinary(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		if(lenA == 0)
			return b;
		if(lenB == 0)
			return a;
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		char tempC;
		for(int i=0;i<lenA/2;i++){
			tempC = charArrayA[i];
			charArrayA[i] = charArrayA[lenA-1-i];
			charArrayA[lenA-1-i] = tempC;
		}
		for(int i=0;i<lenB/2;i++){
			tempC = charArrayB[i];
			charArrayB[i] = charArrayB[lenB-1-i];
			charArrayB[lenB-1-i] = tempC;
		}
		int index = 0,maxIndex = Math.max(lenA, lenB);
		int carray = 0;
		StringBuilder sb  = new StringBuilder();
		while(index<maxIndex){
			int res = carray;
			if(index<lenA){
				res = res+charArrayA[index]-'0';
			}
			if(index<lenB){
				res = res+charArrayB[index]-'0';
			}
			
			sb.append((char) ('0'+res%2));
			carray = res/2;
			index++;
		}
		if(carray!=0){
			
			sb.append((char) ('0'+carray));
		}
		return sb.reverse().toString();
		
	}
}
