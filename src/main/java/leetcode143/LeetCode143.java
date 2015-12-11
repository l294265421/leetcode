package leetcode143;

import global.ListNode;

public class LeetCode143 {
	public void reorderList(ListNode head) {
		// 分两半，找中点，用快慢指针
		ListNode slowListNode = head;
		ListNode slowListNodeParent = null;
		ListNode fastListNode = head;
		while (fastListNode.next != null && fastListNode.next.next != null) {
			slowListNodeParent = slowListNode;
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;
		}
		slowListNodeParent.next = null;
		
		// 反转后一部分链表
		ListNode reverseTail = reverseList(slowListNodeParent);
		
		// 合并
	}
	
	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode p = head;
		ListNode q = head.next;
		p.next = null;
		ListNode r = q.next;
		q.next = p;
		while (r != null) {
			p = q;
			q = r;
			r = r.next;
			q.next = p;
		}
		return q;
	}
}
