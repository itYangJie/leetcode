package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject187 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		if(s.length()<=10)
			return res;
		Map<String,Integer> map = new HashMap<>();
		int len = s.length();
		for(int i=0;i<=len-10;i++){
			String temp = s.substring(i, i+10);
			if(!map.containsKey(temp) ){
				map.put(temp, 1);
				
			}else if(map.get(temp)==1){
				map.put(temp, map.get(temp)+1);
				res.add(temp);
			}
			
		}
		return res;
		
	}
}
