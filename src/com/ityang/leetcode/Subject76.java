package com.ityang.leetcode;

public class Subject76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		if(sLen == 0 || tLen == 0 || sLen<tLen)
			return "";
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int[] tHave = new int[256];
		int[] sHave = new int[256];
		for(int i=0;i<256;i++){
			tHave[i] = sHave[i] = 0;
		}
		for(int i=0;i<tLen;i++){
			tHave[tChars[i]] = tHave[tChars[i]]+1;
		}
		int curStart = 0,curEnd = 0,resStatrt=-1,resEnd=-1,resMin = Integer.MAX_VALUE;
		sHave[sChars[0]] = 1;
		while(curEnd<sLen){
			boolean isContain = true;
			for(int i=0;i<256;i++){
				if(sHave[i]<tHave[i]){
					isContain = false;
					break;
				}
			}
			if(isContain){
				if(curEnd-curStart+1<resMin){
					resStatrt = curStart;
					resEnd = curEnd;
					resMin = curEnd-curStart+1;
				}
				sHave[sChars[curStart]] = sHave[sChars[curStart]]-1;
				curStart++;
				
			}else{
				curEnd++;
				if(curEnd>=sLen)
					break;
				sHave[sChars[curEnd]] = sHave[sChars[curEnd]]+1;
			}
			
			
		}
		if(resMin == Integer.MAX_VALUE)
			return "";
		return s.substring(resStatrt, resEnd+1);
	}
}
