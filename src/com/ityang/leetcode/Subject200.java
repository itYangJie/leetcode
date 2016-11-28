package com.ityang.leetcode;

public class Subject200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numIslands(new char[][]{
			{'1','1','1','1','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'},
		}));
		
		
	}

	public static int numIslands(char[][] grid) {
		
		int rows = grid.length;
		if(rows == 0)
			return 0;
		int columns = grid[0].length;
		boolean[][] isVisited = new boolean[rows][columns];
		int count = 0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(grid[i][j]=='1' && !isVisited[i][j]){
					visit(i,j,isVisited,grid);
					count++;
				}
			}
		}
		return count;
		
	}

	private static void visit(int i, int j, boolean[][] isVisited, char[][] grid) {
		isVisited[i][j] = true;
		if(i-1>=0 && grid[i-1][j]=='1' && !isVisited[i-1][j])
			visit(i-1,j,isVisited,grid);
		
		if(j-1>=0 && grid[i][j-1]=='1' && !isVisited[i][j-1])
			visit(i,j-1,isVisited,grid);
		
		if(i+1<grid.length && grid[i+1][j]=='1' && !isVisited[i+1][j])
			visit(i+1,j,isVisited,grid);
		
		if(j+1<grid[0].length && grid[i][j+1]=='1' && !isVisited[i][j+1])
			visit(i,j+1,isVisited,grid);
		
	}
	
}
