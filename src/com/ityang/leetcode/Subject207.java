package com.ityang.leetcode;

public class Subject207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canFinish1(5, new int[][] { { 0, 2 }, { 1, 0 }, { 3, 0 }, { 4, 3 } }));
	}

	public static boolean canFinish1(int numCourses, int[][] prerequisites) {

		if (numCourses == 1 || prerequisites.length <= 1)
			return true;
		int prerequisitNum = prerequisites.length;

		boolean[][] isReachable = new boolean[numCourses][numCourses];

		int start, end;
		for (int i = 0; i < prerequisitNum; i++) {
			start = prerequisites[i][1];
			end = prerequisites[i][0];
			if (isReachable[end][start])
				return false;
			isReachable[start][end] = true;
			for (int j = 0; j < numCourses; j++) {
				if (isReachable[end][j])
					isReachable[start][j] = true;
				if (isReachable[j][start])
					isReachable[j][end] = true;
			}
		}
		return true;
	}

	
}
