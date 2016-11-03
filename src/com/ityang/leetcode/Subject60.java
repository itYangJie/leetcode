package com.ityang.leetcode;

public class Subject60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(5, 2));
	}

	public static String getPermutation(int n, int k) {
		
		boolean[] isUsed = new boolean[n+1];
		int totalCount = 1;
		for(int i=1;i<=n;i++){
			isUsed[i] = false;
			if(i!=n)
				totalCount *= i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n;i++){
			
			int j = 1 + (k-1)/totalCount;
			int index = 0;
			for(int m=1;m<=n;m++){
				
				if( !isUsed[m] )
					index++;
				if(index==j){
					isUsed[m] = true;
					sb.append(m+"");
					break;
				}
			}
			k = k-(j-1)*totalCount;
			totalCount = totalCount/(n-i);
		}
		for(int m=1;m<=n;m++){
			
			if( !isUsed[m] )
				sb.append(m+"");
			
		}
		return sb.toString();
	}
}
