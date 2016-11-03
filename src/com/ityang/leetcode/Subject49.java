package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject49 {

	public static void main(String[] args) {
		groupAnagrams(new String[]{"and","dan"});

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		int len = strs.length;
		if(len == 0)
			return res;
		Map<String,List<String>> map = new HashMap<>();
		for(int i=0;i<len;i++){
			String s = strs[i];
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			String newS = new String(charArray);
			if(map.containsKey(newS)){
				map.get(newS).add(s);
			}else{
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(newS, list);
				res.add(list);
			}
			
		}
		return res;
	}
}
