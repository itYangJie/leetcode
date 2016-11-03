package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solveNQueens(8);
	}

	public static List<List<String>> solveNQueens(int n) {
		
		List<List<String>> res = new ArrayList<List<String>>();
		if(n<=0)
			return res;
		int[] data = new int[n];
		//boolean[] isUsed = new boolean[n];
		//for(int i=0;i<n;i++)
			//isUsed[i] = false;
		
		char[] cArray = new char[n];
		for(int j=0;j<n;j++){
			cArray[j] = '.';
			data[j] = j;
		}
		
		dfs(data,0,res,n,cArray);
		return res;
	}

	private static void dfs(int[] data, int index, List<List<String>> res, int n, char[] cArray) {
		
		if(index==n){
			boolean isValidata = isValidate(data, n);
			if(isValidata){
				
				List<String> temp = new ArrayList<>();
				
				for(int i=0;i<n;i++){
					//System.out.print(data[i]+" ");
					
					cArray[data[i]] = 'Q';
					String s = new String(cArray);
					cArray[data[i]] = '.';
					temp.add(s);
				}
				//System.out.println();
				res.add(temp);
			}
			return;
		}
		for(int i=index;i<n;i++){
			//if(!isUsed[i]){
				//isUsed[i] = true;
				swap(data,i,index);
				//data[index] = i;
				dfs(data,index+1,res,n,cArray);
				swap(data,i,index);
				//isUsed[i] = false;
			//}
			
		}
		
	}

	private static void swap(int[] data, int i, int index) {
		int temp = data[i];
		data[i] = data[index];
		data[index] = temp;
	}

	private static boolean isValidate(int[] data, int n) {
		
		
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if( i-j==data[i]-data[j] || i-j==data[j]-data[i] ){
					return false;
				}
					
			}
		}
		return true;
	}
}
