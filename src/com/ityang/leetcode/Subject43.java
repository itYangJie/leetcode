package com.ityang.leetcode;

public class Subject43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("011","0011"));
	}

	public static String multiply(String num1, String num2) {
		
		int length1 = num1.length();
		int length2 = num2.length();
		if(num1==null || num2==null || length1==0 || length2==0)
			return "";
		
		char[] num1Array = num1.toCharArray();
		char[] num2Array = num2.toCharArray();
		
		int length = length1+length2;
		char[] res = new char[length];
		
		for(int i=0;i<length;i++)
			res[i] = '0';
		
		for(int i=length1-1;i>=0;i--){
			for(int j=length2-1;j>=0;j--){
				int temp = (num1Array[i]-'0')*(num2Array[j]-'0')+res[i+j+1]-'0';
				res[i+j+1] = (char) (temp%10+'0');
				res[i+j] += temp/10;
			}
		}
		int index = 0;
		while(index<length && res[index]=='0')
			index++;
		if(index==length)
			return "0";
		
		return new String(res,index,length-index);
		
	}
}
