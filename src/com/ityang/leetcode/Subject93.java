package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		restoreIpAddresses("010010");
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if(s==null || s.length()<4)
			return res;
		List<String> temp = new ArrayList<>();
		dfs(res,temp,s,0,0);
		return res;
	}

	private static void dfs(List<String> res, List<String> temp, 
			String s, int have, int index) {
		if(have==4 && index==s.length()){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<3;i++)
				sb.append(temp.get(i)+".");
			sb.append(temp.get(3));
			res.add(sb.toString());
			return;
		}else if(have==4 || index==s.length()){
			return;
		}
		for(int i=index;i<s.length() && i<=index+2;i++){
			int num = Integer.parseInt(s.substring(index,i+1));
			if(num>=0 && num<=255 && (i==index || s.charAt(index)!='0')){
				temp.add(s.substring(index,i+1));
				dfs(res,temp,s,have+1,i+1);
				temp.remove(temp.size()-1);
			}
		}
		
		
	}
	
	
}
