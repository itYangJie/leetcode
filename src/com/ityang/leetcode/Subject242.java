package com.ityang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Subject242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("adad","cdaa"));
	}

	public static boolean isAnagram(String s, String t) {
		
		if(s.length()!=t.length())
			return false;
		if(s.length()==0)
			return true;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1+map.get(s.charAt(i)));
			else
				map.put(s.charAt(i), 1);
		}
		for(int i=0;i<t.length();i++){
			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0)
				map.put(t.charAt(i), map.get(t.charAt(i))-1);
			else
				return false;
		}
		return true;
	}
}
