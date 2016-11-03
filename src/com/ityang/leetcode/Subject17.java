package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subject17 {

	public static void main(String[] args) {
		List<String> res = letterCombinations("23");
		Iterator<String> iterator = res.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	private static char[][] datas = {
		{'a','b','c'},		//2
		{'d','e','f'},		//3
		{'g','h','i'},		//4
		{'j','k','l'},		//5
		{'m','n','o'},		//6
		{'p','q','r','s'},	//7
		{'t','u','v'},		//8
		{'w','x','y','z'}	//9
	};
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if(digits==null || digits.length()==0)
			return  res;
		
		char[] charArray = digits.toCharArray();
		dfs(charArray,"",digits.length(),res);
		return res;
	}
	private static void dfs(char[] charArray,String current,int need,List<String> list){
		if(need<=0){
			list.add(current);
			return;
		}
		int index = charArray.length-need;
		int arrayIndex = charArray[index]-'2',loopNum = 3;
		if(arrayIndex == 5 || arrayIndex == 7){
			loopNum = 4;
		}
		for(int i=0;i<loopNum;i++){
			dfs(charArray,current+datas[arrayIndex][i],need-1,list);
		}
		
	}
}
