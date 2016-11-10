package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject131 {
	
	public static void main(String[] args) {
		partition("aab");
	}
	
	public static List<List<String>> partition(String s) {
		
		List<List<String>> res = new ArrayList<List<String>>();
		if(s==null || s.isEmpty())
			return res;
		List<String> temp = new ArrayList<>();
		dfs(res,temp,0,s.toCharArray());
		
		return res;
	}

	private static void dfs(List<List<String>> res, List<String> temp, 
			int curIndex, char[] charArray) {
		if(curIndex>=charArray.length){
			res.add(new ArrayList(temp));
			return ;
		}
		
		for(int i=curIndex;i<charArray.length;i++){
			if(isPalindrome(charArray,curIndex,i)){
				temp.add(new String(charArray,curIndex,i-curIndex+1));
				dfs(res,temp,i+1,charArray);
				temp.remove(temp.size()-1);
			}
		}
		
	}

	private static boolean isPalindrome(char[] charArray, int start, int end) {
		
		while(start<end){
			if(charArray[start]!=charArray[end])
				return false;
			start++;end--;
		}
		return true;
	}
}
