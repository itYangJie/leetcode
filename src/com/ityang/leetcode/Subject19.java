package com.ityang.leetcode;

public class Subject19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		/*int length = 0;
		ListNode resHead = head;
		while(head!=null){
			length++;
			head = head.next;
		}
		int removeN = length+1-n;
		if(removeN==1)
			return resHead.next;
		ListNode pre=resHead,cur=resHead.next;
		int curIndex = 2;
		while(curIndex<removeN){
			pre = pre.next;
			cur = cur.next;
			curIndex++;
		}
		pre.next = cur.next;
		return resHead;*/
		ListNode fast = head;
		for(int i=0;i<n;i++){
			if(fast==null)
				return head.next;
			fast = fast.next;
		}
		if(fast==null)
		    return head.next;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
}
