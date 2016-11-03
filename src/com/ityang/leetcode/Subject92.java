package com.ityang.leetcode;

import com.ityang.leetcode.Subject86.ListNode;

public class Subject92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null || m==n)
			return head;
		ListNode font = new ListNode(Integer.MAX_VALUE),pPre = font,pre = head,cur,next;
		font.next = head;
		int index = 1;
		while(pre!=null && index<m){
			pre = pre.next;
			pPre = pPre.next;
			index++;
		}
		cur = pre.next;
		next = cur.next;
		while(index<n){
			cur.next = pre;
			pre = cur;
			cur = next;
			if(next!=null)
				next = next.next;
			index++;
		}
		ListNode temp = pPre.next;
		pPre.next = pre;
		temp.next = cur;
		return font.next;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
