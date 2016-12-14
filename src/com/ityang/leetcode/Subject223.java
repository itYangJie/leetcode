package com.ityang.leetcode;

public class Subject223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}

	public static int computeArea(int A, int B, int C, int D, 
			int E, int F, int G, int H) {
		int width = 0,height = 0;
		if(A<=E){
			if(E>=C)
				width = 0;
			else 
				width = (C-E)>(G-E)?(G-E):(C-E);
		}else{
			if(A>=G)
				width = 0;
			else 
				width = (G-A)>(C-A)?(C-A):(G-A);
		}
		if(width==0)
			return 0;
		
		if(B<=F){
			if(D<=F)
				height = 0;
			else 
				height = (D-F)>(H-F)?(H-F):(D-F);
		}else{
			if(B>=H)
				height = 0;
			else 
				height = (H-B)>(D-B)?(D-B):(H-B);
		}
		return width*height;
	}
}
