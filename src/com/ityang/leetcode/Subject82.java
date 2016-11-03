package com.ityang.leetcode;

public class Subject82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode deleteDuplicates(ListNode head) {
		
		if( head==null || head.next==null)
			return head;
		ListNode res = new ListNode(-1),curRes = res,cur = head;
		int count = 1;
		while(cur!=null){
			
			while(cur.next!=null && cur.val==cur.next.val){
				cur = cur.next;
			}
			if(count == 1){
				curRes.next = cur;
				curRes = curRes.next;
			}
			count = 1;
			cur = cur.next;
			
		}
		curRes.next = null;
		return res.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
