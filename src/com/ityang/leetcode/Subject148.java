package com.ityang.leetcode;

import java.util.Collections;
import java.util.Random;

public class Subject148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode font = new ListNode(Integer.MAX_VALUE),cur = font;
		Random random = new Random();
		for(int i=1;i<=2000000;i++){
			cur.next = new ListNode(2000001-i);
			cur = cur.next;
		}
		
		long startTime = System.currentTimeMillis();
		ListNode res = sortList(font.next);
		long endTime = System.currentTimeMillis();
		System.out.println("用时:"+(endTime-startTime));
		System.out.println("最小值"+res.val);
	}

	public static ListNode sortList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		return mergeSortList(head);
	}

	private static ListNode mergeSortList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode slow = head,fast = head;
		while(fast!=null && fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		ListNode lefts = mergeSortList(head);
		ListNode rights = mergeSortList(fast);
		
		if(lefts == null)
			return rights;
		if(rights == null)
			return lefts;
		
		ListNode font = new ListNode(Integer.MIN_VALUE),tail = font;
		while(lefts!=null && rights!=null){
			if(lefts.val>=rights.val){
				tail.next = rights;
				tail = tail.next;
				rights = rights.next;
			}else{
				tail.next = lefts;
				tail = tail.next;
				lefts = lefts.next;
			}
		}
		if(lefts!=null){
			tail.next = lefts;
		}
		if(rights!=null){
			tail.next = rights;
		}
		return font.next;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
