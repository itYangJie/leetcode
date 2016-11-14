package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject140 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<>();
		wordDict.add("a");
		wordDict.add("abc");
		wordDict.add("b");
		wordDict.add("cd");
		//wordDict.add("dog");
		wordBreak("abcd", wordDict);
	}

	public static List<String> wordBreak(String s, Set<String> wordDict) {
		
		boolean[] isWordBreak = new boolean[s.length()+1];
		isWordBreak[0] = true;
		List<Integer> indexList = new ArrayList<>();
		for(int i=1;i<=s.length();i++){
			
			for(int j=0;j<i;j++){ //dsaddvvsd
				if(isWordBreak[j] && wordDict.contains(s.substring(j,i))){
					isWordBreak[i] = true;
					indexList.add(i-1);
					break;
				}
			}
			
		}
		List<String> res = new ArrayList<>();
		if(!isWordBreak[s.length()])
			return res;
		
		 StringBuffer sb = new StringBuffer();
		 dfs(s,res,indexList,0,0,wordDict,sb);
		 return res;
	}

	private static void dfs(String s, List<String> res,
			List<Integer> indexList, int index,int listIndex,
			Set<String> wordDict, StringBuffer sb) {
		
		if(index>=s.length()){
			res.add(sb.toString().trim());
			return;
		}
		for(int i=listIndex;i<indexList.size();i++){
			int originIndex = indexList.get(i);
			
			if(wordDict.contains(s.substring(index,originIndex+1))){
				int preLength = sb.length();
				sb.append(s.substring(index,originIndex+1)+" ");
				dfs(s,res,indexList,originIndex+1,i+1,wordDict,sb);
				sb.delete(preLength,sb.length());
			}
		}
		
	}
	
	
}
