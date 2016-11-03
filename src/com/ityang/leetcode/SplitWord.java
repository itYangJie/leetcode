package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitWord {

	public static void main(String[] args) {
		split("/a/./b/../../c/");

	}
	private static List<String> split(String str){
		int len = str.length();
		char[] chars = str.toCharArray();
		int start = 0,end = 0;
		List<String> res = new ArrayList<>();
		while(start < len){
			
			if(chars[start]=='/'){
				start++;end++;
			}else if( end==len || chars[end]=='/' ){
				res.add(new String(chars, start, end-start));
				start = end;
			}else{
				end++;
			}
			
		}
		return res;
	}
}
