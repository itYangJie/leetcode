package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		dfs(res,0,0,n,"");
		return res;
	}
	
	public static void dfs(List<String> res,int open,int close,
			int n,String cur){
		if(cur.length()==2*n){
			res.add(cur);
			return;
		}
		if(open>=n)
			dfs(res,open,close+1,n,cur+")");
		else if(open>close){
			dfs(res,open,close+1,n,cur+")");
			dfs(res,open+1,close,n,cur+"(");
		}else{
			dfs(res,open+1,close,n,cur+"(");
		}
		
			
	}
}
