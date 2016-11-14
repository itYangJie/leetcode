package com.ityang.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Subject139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak2("leet", wordDict));
	}

	public static boolean wordBreak2(String s, Set<String> wordDict) {

		/*if (s == null || s.length() == 0 || wordDict.size() == 0)
			return false;*/

		boolean[] isWordBreak = new boolean[s.length()+1];
		
		isWordBreak[0] = true;
		
		
		for(int i=1;i<=s.length();i++){
			
			for(int j=0;j<i;j++){ //dsaddvvsd
				if(isWordBreak[j] && wordDict.contains(s.substring(j,i))){
					isWordBreak[i] = true;
					break;
				}
			}
			
		}
		
		return isWordBreak[s.length()];
	}

	public static boolean wordBreak1(String s, Set<String> wordDict) {

		if (s == null || s.length() == 0 || wordDict.size() == 0)
			return false;

		return dfs(s, wordDict);
	}

	private static boolean dfs(String s, Set<String> wordDict) {

		if ("".equals(s))
			return true;

		for (String string : wordDict) {
			if (s.startsWith(string) && dfs(s.substring(string.length()), wordDict))
				return true;
		}
		return false;
	}
}
