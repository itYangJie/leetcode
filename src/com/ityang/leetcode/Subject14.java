package com.ityang.leetcode;

public class Subject14 {

	public static void main(String[] args) {
		
		System.out.println(longestCommonPrefix(new String[]{"","b"}));
	}
    public static String longestCommonPrefix(String[] strs) {
        
    	if(strs==null || strs.length==0)
    		return "";
    	int strNum = strs.length;
    	int index = 0;
    	int minLength = strs[0].length();
    	for(int i=1;i<strNum;i++){
    		if(minLength>strs[i].length())
    			minLength = strs[i].length();
    	}
    	while(true){
    		if(index>minLength-1)
    			break;
    		boolean isEqual = true;
    		char c = strs[0].charAt(index);
    		for(int i=1;i<strNum;i++){
    			if(strs[i].charAt(index)!=c){
    				isEqual = false;
    				break;
    			}
    		}
    		
    		if(!isEqual)
				break;
			index++;
    	}
    	return strs[0].substring(0, index);
    	
    }
}
