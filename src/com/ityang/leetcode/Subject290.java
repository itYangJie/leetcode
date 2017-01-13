package com.ityang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subject290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if(pattern.length()!=strs.length)
			return false;
		Map<Character,String> map = new HashMap<>();
		
		for(int i=0;i<pattern.length();i++){
			if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(strs[i]))
				map.put(pattern.charAt(i), strs[i]);
			else if(!map.containsKey(pattern.charAt(i)) || !map.containsValue(strs[i]))
				return false;
		}
		return true;
	}
}
