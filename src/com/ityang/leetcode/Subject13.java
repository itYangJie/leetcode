package com.ityang.leetcode;

import java.util.HashMap;

public class Subject13 {

	public static void main(String[] args) {
		System.out.println(romanToInt("MMMCCXIV"));

	}

	public static int romanToInt(String s) {
		if(s==null || s.length()==0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);
	    
	    int len = s.length();
	    int res = map.get(s.charAt(len-1)),cur,pre=res;
	    for(int i=len-2;i>=0;i--){
	    	cur = map.get(s.charAt(i));
	    	if(cur<pre)
	    		res -= cur;
	    	else
	    		res += cur;
	    	pre = cur;
	    }
	    return res;
	}
}
