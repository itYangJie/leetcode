package com.ityang.leetcode;

public class Subject58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("1 1as  "));
	}

	public static int lengthOfLastWord(String s) {
		if(s==null || s.length()==0)
			return 0;
		int lengthS=s.length();
		char[] data = s.toCharArray();
 	    //int a=-1,b=-1,count=0;
	    
	    /*for(int i=lengthS-1;i>-1;i--){
	     
	        if(count==0&&s.charAt(i)!=' '){
	            b=i;
	            count=1;
	        }
	        if(count==1&&s.charAt(i)==' '){
	            a=i;
	            return b-a;
	        }
	        
	    }
	    
	    return b-a;*/
		int end = lengthS-1;
		while(end>=0 && data[end]==' ')
			end--;
		if(end<0)
			return 0;
		int start = end;
		while(start>=0 && data[start]!=' ')
			start--;
		return end-start;
	}
}
