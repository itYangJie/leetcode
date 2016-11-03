package com.ityang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Subject57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		
		List<Interval> res = new ArrayList<>();
		if (intervals.size() == 0 ){
			res.add(newInterval);
			return res;
		}

		intervals.add(newInterval);
		int len = intervals.size();
		Collections.sort(intervals, new MyCompartor());
		for (int i = 0; i < len; i++) {

			int start = intervals.get(i).start;
			int end = intervals.get(i++).end;

			while (i < len && intervals.get(i).start <= end) {
				end = Math.max(end, intervals.get(i++).end);
			}

			res.add(new Interval(start, end));
			i--;

		}
		return res;
	}

	private static class MyCompartor implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start)
				return 1;
			else if (o1.start < o2.start)
				return -1;
			else
				return 0;
		}

	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
