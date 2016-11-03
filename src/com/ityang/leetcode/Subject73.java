package com.ityang.leetcode;

public class Subject73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		
/*		int rowNum = matrix.length;
		int columnNum = matrix[0].length;
		
		for(int i=0;i<rowNum;i++)
			for(int j=0;j<columnNum;j++){
				if(matrix[i][j]==0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
					
				}
			}
		
		for(int i=1;i<rowNum;i++){
			if(matrix[i][0] == 0 ){
				for(int j=1;j<columnNum;j++)
					matrix[i][j] = 0;
			}
		}
		
		for(int i=1;i<columnNum;i++){
			if(matrix[0][i] == 0 ){
				for(int j=1;j<rowNum;j++)
					matrix[j][i] = 0;
			}
		}
		if(matrix[0][0] == 0){
			for(int j=1;j<columnNum;j++)
				matrix[0][j] = 0;
			for(int j=1;j<rowNum;j++)
				matrix[j][0] = 0;
		}*/
		if(matrix==null) return;
        final int M=matrix.length, N=matrix[0].length;
        boolean topZero=false, leftZero=false;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j]==0){
                    if(i==0) topZero = true;
                    if(j==0) leftZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<M; i++){
            if(matrix[i][0]==0){
                for(int q=1; q<N; q++) matrix[i][q] = 0;
            }
        }
        for(int j=1; j<N; j++){
            if(matrix[0][j]==0){
                for(int p=1; p<M; p++)  matrix[p][j] = 0;
            }
        }
        if(topZero){
            for(int q=0; q<N; q++) matrix[0][q] = 0;
        }
        if(leftZero){
            for(int p=0; p<M; p++) matrix[p][0] = 0;
        }
		
	}
}
