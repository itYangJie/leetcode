package com.ityang.leetcode;

public class Subject130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void solve(char[][] board) {
		
		int rows = board.length;
		if(rows == 0)
			return;
		int columns = board[0].length;
		
		for(int i=0;i<columns;i++){
			if(board[0][i]=='O')
				dfs(0,i,board,rows,columns);
			
			if(board[rows-1][i]=='O')
				dfs(rows-1,i,board,rows,columns);
		}
		for(int i=1;i<rows-1;i++){
			if(board[i][0]=='O')
				dfs(i,0,board,rows,columns);
			
			if(board[i][columns-1]=='O')
				dfs(i,columns-1,board,rows,columns);
		}
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(board[i][j]=='1')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
		}
		
		
	}

	private static void dfs(int i, int j, char[][] board, int rows, int columns) {
		
		board[i][j] = '1';
		
		if(i-1>=0 && board[i-1][j]=='O')
			dfs(i-1,j,board,rows,columns);
		
		if(j+1<columns && board[i][j+1]=='O')
			dfs(i,j+1,board,rows,columns);
		
		if(i+1<rows && board[i+1][j]=='O')
			dfs(i+1,j,board,rows,columns);
		
		if(j-1>=0 && board[i][j-1]=='O')
			dfs(i,j-1,board,rows,columns);
	}
}
