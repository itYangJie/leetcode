package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public static boolean canFinish2(int numCourses, int[][] prerequisites) {

		if (numCourses == 1 || prerequisites.length <= 1)
			return true;
		int prerequisitNum = prerequisites.length;

		List<List<Integer>> topLists = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			topLists.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisitNum; i++) {
			topLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		boolean[] visited = new boolean[numCourses];
		boolean[] path = new boolean[numCourses];
		
		for(int i=0;i<numCourses;i++){
			if(hasCycle(topLists,visited,path,i))
				return false;
		}
		return true;
	}

	private static boolean hasCycle(List<List<Integer>> topLists,
			boolean[] visited, boolean[] path, int course) {
		
		if(path[course])
			return true;
		if(visited[course] || topLists.get(course).size()==0)
			return false;
		visited[course] = true;
		path[course] = true;
		for(int j=topLists.get(course).size();j>=0;j--){
			if(hasCycle(topLists, visited, path, topLists.get(course).get(j)))
				return true;
		}
		path[course] = false;
		return false;
	}
	public static boolean canFinish3(int numCourses, int[][] prerequisites) {
		int edges =  prerequisites.length;
		Queue<Integer> zeroInDegree = new LinkedList<Integer>();
		int[] inDegree = new int[numCourses];
		
		List<List<Integer>> topLists = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			topLists.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges; i++) {
			topLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
			inDegree[prerequisites[i][0]]++;
		}
		for(int i = 0;i<numCourses;i++)
			if(inDegree[i]==0)
				zeroInDegree.add(i);
		
		while(!zeroInDegree.isEmpty()){
			int curCourse = zeroInDegree.poll();
			for(int i=topLists.get(curCourse).size()-1;i>=0;i--){
				edges--;
				if(--inDegree[topLists.get(curCourse).get(i)] ==0)
					zeroInDegree.add(topLists.get(curCourse).get(i));
				
			}
			
		}
		if(0!=edges)
			return false;
		return true;
	}
}
