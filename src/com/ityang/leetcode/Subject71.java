package com.ityang.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class Subject71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}

	public static String simplifyPath(String path) {
		String[] split = path.split("/");
		
		int len = split.length;
		LinkedList<String> list = new LinkedList<>();
		for(int i=0;i<len;i++){
			if(split[i].equals("..") && list.size()!=0){
				list.removeLast();
			}
			else if(!split[i].equals(".") && !split[i].equals("") && !split[i].equals("..")){
				list.add(split[i]);
			}
		}
		if(list.size() == 0)
			return "/";
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			sb.append("/"+iterator.next());
		}
		return sb.toString();
	}
}
