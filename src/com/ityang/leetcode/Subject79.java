package com.ityang.leetcode;

public class Subject79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(exist(new char[][]{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}

		}, "ABCB"));
	}

	public static boolean exist(char[][] board, String word) {
		int rows = board.length;
		int columns = board[0].length;
		char[] pChars = word.toCharArray();
		boolean[][] isUsed = new boolean[rows][columns];
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
				isUsed[i][j] = false;
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if( board[i][j]==pChars[0] && dfs(i,j,board,isUsed,pChars,1,rows,columns))
					return true; 	
			}
			
		}
		return false;
	}
	
	public static boolean dfs(int rowIndex,int columnIndex,char[][] board,boolean[][] isUsed,
			char[] pChars,int haveMatch,int rowCount,int columnCount){
		if(haveMatch==pChars.length)
			return true;
		
		isUsed[rowIndex][columnIndex] = true;
		
		int rowNextIndex,columnNextIndex;
		
		boolean isMatch = false;
		
		rowNextIndex = rowIndex;
		columnNextIndex = columnIndex+1;
		if(columnNextIndex<columnCount && !isUsed[rowNextIndex][columnNextIndex] 
				&& board[rowNextIndex][columnNextIndex]==pChars[haveMatch]){
			isMatch = dfs(rowNextIndex,columnNextIndex,board,isUsed,pChars,haveMatch+1,rowCount,columnCount);
		}
		rowNextIndex = rowIndex;
		columnNextIndex = columnIndex-1;
		if(!isMatch && columnNextIndex>=0 && !isUsed[rowNextIndex][columnNextIndex] 
				&& board[rowNextIndex][columnNextIndex]==pChars[haveMatch]){
			isMatch = dfs(rowNextIndex,columnNextIndex,board,isUsed,pChars,haveMatch+1,rowCount,columnCount);
		}
		rowNextIndex = rowIndex-1;
		columnNextIndex = columnIndex;
		if(!isMatch && rowNextIndex>=0 && !isUsed[rowNextIndex][columnNextIndex] 
				&& board[rowNextIndex][columnNextIndex]==pChars[haveMatch]){
			isMatch = dfs(rowNextIndex,columnNextIndex,board,isUsed,pChars,haveMatch+1,rowCount,columnCount);
		}
		rowNextIndex = rowIndex+1;
		columnNextIndex = columnIndex;
		if(!isMatch && rowNextIndex<rowCount && !isUsed[rowNextIndex][columnNextIndex] 
				&& board[rowNextIndex][columnNextIndex]==pChars[haveMatch]){
			isMatch = dfs(rowNextIndex,columnNextIndex,board,isUsed,pChars,haveMatch+1,rowCount,columnCount);
		}
		isUsed[rowIndex][columnIndex] = false;
		return isMatch;
	}
}
