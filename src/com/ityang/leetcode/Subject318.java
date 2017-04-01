package com.ityang.leetcode;

public class Subject318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
	}

	public static int maxProduct(String[] words) {
		if (words == null || words.length < 2)
			return 0;
		int val[] = new int[words.length];
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				val[i] = val[i] | (1<<words[i].charAt(j)-'a');
			}
		}
		int ret = 0;
		for(int i=0;i<words.length-1;i++){
			for(int j=i+1;j<words.length;j++){
				if( (val[i] & val[j])==0 && ret<words[i].length()*words[j].length())
					ret = words[i].length()*words[j].length();
			}
		}
		return ret;
	}
}
