package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subject54 {

	public static void main(String[] args) {
		spiralOrder(new int[][]{
			{ 2,3}
			
			
		});
		
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> rs = new ArrayList<>();
        if(matrix.length == 0) return rs;
        int m = matrix[0].length, n = matrix.length, layer=0;
        while(layer<=(m-1)/2 && layer<=(n-1)/2){
            //add the top
            for(int i=layer;i<m-layer;i++){
                rs.add(matrix[layer][i]);
            }
            //add right side
            for(int i=layer+1;i<n-layer;i++){
                rs.add(matrix[i][m-layer-1]);
            }
            if(layer<n/2)
                //add bottom
                for(int i=m-1-layer-1;i>=layer;i--){
                    rs.add(matrix[n-layer-1][i]);
                }
            if(layer<m/2)
                //add right side
                for(int i=n-1-layer-1;i>=layer+1;i--){
                    rs.add(matrix[i][layer]);
                }
            layer++;
        }
        return rs;
	}
	
	
}
