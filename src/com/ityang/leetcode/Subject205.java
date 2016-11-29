package com.ityang.leetcode;

import java.util.HashMap;

public class Subject205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("ab", "aa"));
	}

	public static boolean isIsomorphic(String s, String t) {
		
		if(s.length()==0 && t.length()==0)
			return true;
		else if(s.length()==0 || t.length()==0 || s.length()!=t.length())
			return false;
		HashMap<Character,Character> mappings = new HashMap<>();
		for(int i=s.length()-1;i>=0;i--){
			if(mappings.containsKey(s.charAt(i))){
				if(mappings.get(s.charAt(i))!=t.charAt(i))
					return false;
			}else{
				mappings.put(s.charAt(i), t.charAt(i));
			}
		}
		mappings.clear();
		for(int i=s.length()-1;i>=0;i--){
			if(mappings.containsKey(t.charAt(i))){
				if(mappings.get(t.charAt(i))!=s.charAt(i))
					return false;
			}else{
				mappings.put(t.charAt(i), s.charAt(i));
			}
		}
		return true;
	}
}
