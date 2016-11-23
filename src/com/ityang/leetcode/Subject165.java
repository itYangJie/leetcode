package com.ityang.leetcode;

public class Subject165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.0", "1.0.0"));
	}

	public static int compareVersion(String version1, String version2) {
		
		String[] datas1 = version1.split("\\.");
		String[] datas2 = version2.split("\\.");
		
		int len1 = datas1.length,len2 = datas2.length;
		int index = 0,data1,data2;
		while(index<len1 && index<len2){
			data1 = Integer.valueOf(datas1[index]);
			data2 = Integer.valueOf(datas2[index]);
			if(data1<data2){
				return -1;
			}else if(data1>data2){
				return 1;
			}else{
				index++;
			}
		}
		if(len1 == len2)
			return 0;
		int  cur = index;
		while(cur<len1){
			if(Integer.valueOf(datas1[cur])!=0)
				return 1;
			cur++;
		}
		cur = index;
		while(cur<len2){
			if(Integer.valueOf(datas2[cur])!=0)
				return -1;
			cur++;
		}
		return 0;
	}
}
