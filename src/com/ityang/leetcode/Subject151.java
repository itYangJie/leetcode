package com.ityang.leetcode;

import java.util.Stack;

public class Subject151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("  dsdsa sd 32 .dsa  "));
	}

	public static String reverseWords(String s) {
		
		if("".equals(s))
			return "";
		
		Stack<String> stack = new Stack<>();
		int len = s.length();
		int start = 0,end = 0;
		while(start!=len){
			if(s.charAt(start)==' '){
				start++;
				end++;
			}else if(end == len || s.charAt(end)==' '){
				stack.push(s.substring(start,end));
				start = end;
			}else{
				end++;
			}
			
		}
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()){
			sb.append(stack.pop()+" ");
		}
		return sb.toString().trim();
	}
}
