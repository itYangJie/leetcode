package com.ityang.leetcode;

public class Subject138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		
		if(head==null)
			return null;
		RandomListNode cur = head;
		while(cur!=null){
			RandomListNode nodeCopy = new RandomListNode(cur.label);
			nodeCopy.next = cur.next;
			cur.next = nodeCopy;
			cur = nodeCopy.next;
		}
		cur = head;
		while(cur!=null){
			cur.next.random = cur.random==null?null:cur.random.next;
			cur = cur.next.next;
		}
		cur = head;
		RandomListNode res = head.next,next;
		while(cur!=null && cur.next!=null){
			next = cur.next;
			cur.next = cur.next.next;
			cur = next;
		}
		
		return res;
	}

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}
}
