package com.ityang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Subject149 {

	public static void main(String[] args) {
		Point[] points = new Point[3];
		
		points[0]= new Point(2,3);
		points[1]= new Point(3,3);
		points[2]= new Point(-5,3);
		 int res = maxPoints(points);
		System.out.println(res);
	}

	public static int maxPoints(Point[] points) {
		
		if(points==null || points.length==0)
			return 0;
		if(points.length==1 || points.length==2)
			return points.length;
		int len = points.length,max = Integer.MIN_VALUE;
		
		int[] count = new int[len];
		Arrays.fill(count, 1);
		for(int i=0;i<len-1;i++){
			if(count[i]==0)
				continue;
			for(int j=i+1;j<len;j++){
				if(points[i].x==points[j].x && points[i].y==points[j].y){
					count[j] = 0;
					count[i]++;
				}
			}
		}
		Map<Double, Integer> lines = new HashMap<>();
		
		for(int i=0;i<len-1;i++){
			if(count[i]==0)
				continue;
			
			lines.clear();
			
			
			for(int j=i+1;j<len;j++){
				if(count[j]==0)
					continue;
				double k;
				if(points[i].x == points[j].x)
					k = Double.MAX_VALUE;
				else if(points[i].y == points[j].y)
					k = 0.0;
				else
					k = (points[i].y-points[j].y)*1.0/(points[i].x-points[j].x);
				int num = count[j];
				if(lines.containsKey(k)){
					num = num+lines.get(k);
				}else
					num = num+count[i];
				max = Math.max(max, num);
				lines.put(k, num);
				
			}
		}
		
		return max;
	}


	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}
