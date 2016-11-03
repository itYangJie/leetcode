package com.ityang.leetcode;

public class Subject28 {

	public static void main(String[] args) {
		System.out.println(strStr("adadfdd", "d"));

	}

	public static int strStr(String haystack, String needle) {
		
		if(needle.length()==0 )
		    return 0;
		if(haystack.length()==0)
			return -1;
		char[] sCharArray = haystack.toCharArray();
		char[] pCharArray = needle.toCharArray();
		int next[] = getNext(pCharArray);
		int i=0,j=0;
		while(i<sCharArray.length && j<pCharArray.length){
			if(j==-1 || sCharArray[i] == pCharArray[j]){
				i++;j++;
			}else
				j = next[j];
		}
		if(j==pCharArray.length)
			return i-j;
		else
			return -1;
		
	}

	private static int[] getNext(char[] pCharArray) {
		int len = pCharArray.length;
		int[] next = new int[len];
		int i=0,j=next[0]=-1;
		while(i<len-1){
			if(j==-1 || pCharArray[i]==pCharArray[j]){
				next[++i] = ++j;
			}else{
				j = next[j];
			}
		}
		return next;
	}
}
