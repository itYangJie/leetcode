package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subject210 {

	public static void main(String[] args) {
	

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int edges =  prerequisites.length;
		Queue<Integer> zeroInDegree = new LinkedList<Integer>();
		int[] inDegree = new int[numCourses];
		
		List<Integer> res = new ArrayList<>();
		
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
			res.add(curCourse);
			for(int i=topLists.get(curCourse).size()-1;i>=0;i--){
				edges--;
				if(--inDegree[topLists.get(curCourse).get(i)] ==0)
					zeroInDegree.add(topLists.get(curCourse).get(i));
				
			}
			
		}
		if(0!=edges)
			return new int[]{};
		int[] resArray = new int[numCourses];
		for(int i=res.size()-1;i>=0;i--){
			resArray[i] = res.get(i);
		}
		return resArray;
	}

}