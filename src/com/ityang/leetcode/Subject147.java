package com.ityang.leetcode;

import java.util.Random;

import com.ityang.leetcode.Subject148.ListNode;

public class Subject147 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode font = new ListNode(Integer.MAX_VALUE),cur = font;
		Random random = new Random();
		for(int i=1;i<=30000;i++){
			cur.next = new ListNode(random.nextInt(20000));
			cur = cur.next;
		}
		
		long startTime = System.currentTimeMillis();
		ListNode res = insertionSortList(font.next);
		long endTime = System.currentTimeMillis();
		System.out.println("用时:"+(endTime-startTime));
		System.out.println("最小值"+res.val);
	}

	public static ListNode insertionSortList(ListNode head) {
		if( head == null || head.next == null){
			return head;
		}
		
		ListNode font = new ListNode(Integer.MIN_VALUE); 
		font.next = head;
		ListNode cur = head.next; 
		ListNode pre = null; 
		ListNode next = null; 
		head.next = null;
		while( cur != null ){
			next = cur.next;
			pre = font;
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
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
