package com.ityang.leetcode;

public class Subject62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3, 7));
	}

	public static int uniquePaths(int m, int n) {
		if(m<1 || n<1)
			return 0;
		if( m==1 || n==1)
			return 1;
		m = m-1;
		n = n-1;
		
		if(n>m){
			//int temp = m;
			//m = n;
			//n = temp;
			n = n^m;
			m = m^n;
			n = n^m;
			
			//n = n ^ (m = m^(n = n^m));
		}
		double res = 1;
		for(int i=1;i<=n;i++){
			res = res*(m+i)*1.0/i;
		}
		return (int) res;
	}
}
