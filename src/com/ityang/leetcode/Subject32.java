package com.ityang.leetcode;

import java.util.Stack;

public class Subject32 {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()()((((())))"));

	}

	public static int longestValidParentheses(String s) {
		if(s==null || s.length()==0 || s.length()==1)
			return 0;
		char[] charArray = s.toCharArray();
		int[] match = new int[charArray.length];
		int len = charArray.length;
		for(int i=0;i<len;i++)
			match[i] = -1;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<len;i++){
			if(charArray[i]=='(')
				stack.push(i);
			else{
				if(!stack.isEmpty())
					match[stack.pop()] = i;
			}
			
		}
		int res = 0,start = 0,end=0;
		while(start<len){
			if(match[start]==-1){
				start++;
				continue;
			}
			end = match[start]+1;
			while(end<len && match[end]!=-1){
				end = match[end]+1;
			}
			
			res = Math.max(res, end-start);
			start = end;
		}
		return res;
	}
}
