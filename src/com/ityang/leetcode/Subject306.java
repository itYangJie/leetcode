package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject306 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAdditiveNumber("121474836472147483648"));
	}

	public static boolean isAdditiveNumber(String num) {
		if(num.length()<3)
			return false;
		List<Long> list = new ArrayList<>();
		
		return dfs(num,list,0);
	}
	
	//1123  199100199 
	private static boolean dfs(String num, List<Long> list, int index) {
		
		
		if(list.size()>2 && list.get(list.size()-1)!=list.get(list.size()-2)+list.get(list.size()-3)){
			return false;
		}
		if(index>=num.length()){
			if(list.size()<=2)
				return false;
			return true;
		}
		if(num.charAt(index)=='0'){
			list.add((long) 0);
			if(dfs(num,list,index+1))
				return true;
			list.remove(list.size()-1);
			return false;
		}
		
		for(int i=index;i<num.length();i++){
			long curNum;
			try{
				curNum = Long.parseLong(num.substring(index, i+1));
			}catch(Exception e){
				return false;
			}
			list.add(curNum);
			if(dfs(num,list,i+1))
				return true;
			list.remove(list.size()-1);
		}
		return false;
	}
}
