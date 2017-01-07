package com.ityang.leetcode;

import java.util.Iterator;

public class Subject284 {

}

class PeekingIterator implements Iterator<Integer> {
	
	private Iterator<Integer> mIterator = null;
	private Integer next = null;
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		mIterator = iterator;
		next = mIterator.hasNext() ? mIterator.next():null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int res = next;
		next = mIterator.hasNext() ? mIterator.next():null;
		return res;
	}

	@Override
	public boolean hasNext() {
		return next!=null;
	}
}