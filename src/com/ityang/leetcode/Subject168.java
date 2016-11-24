package com.ityang.leetcode;

public class Subject168 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(1000000001));
	}

	public static String convertToTitle(int n) {
		 StringBuilder s = new StringBuilder();
	        int len=1;
	        //Find the length of final String
	        double temp = n;
	        while(temp>26){
	            len++;
	            temp=(temp-26)/26;
	        }
	        //Find each character of String
	        while(len>0){
	            int num = n%26;
	            if(num==0)num=26;//case when num is 0
	            char ch = (char) ('A'+ num-1);
	            s.append(ch);
	            len--;
	            n=(n-num)/26;
	        }
	        //reverse the string as we are finding from right to left
	        return s.reverse().toString();
	}
}
