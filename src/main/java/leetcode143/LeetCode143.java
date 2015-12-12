package leetcode143;

import global.ListNode;

public class LeetCode143 {
	public void reorderList(ListNode head) {
		// 只有节点数大于2时才需要reorder
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		// 分两半，找中点，用快慢指针
		ListNode helper = new ListNode(-1);
		helper.next = head;
		ListNode slowListNode = helper;
		ListNode fastListNode = helper;
		while (fastListNode.next != null && fastListNode.next.next != null) {
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;
		}
		
		ListNode hindHead = slowListNode.next;
		slowListNode.next = null;
		// 反转后一部分链表
		hindHead = reverseList(hindHead);
		
		// 合并
		ListNode cursor = head;
		ListNode hindCursor = hindHead;
		// 将hindHead中的元素插入head;
		// hindHead中的元素要么与head中元素个数相等，要么多1
		while (cursor != null) {
			ListNode temp = cursor.next;
			cursor.next = hindCursor;
			hindCursor = hindCursor.next;
			// 这个条件用于解决，当hindHead中的元素比head中元素个数多1时
			// 需要向head尾部添加hindHead尾部元素的问题；
			if (temp != null) {
				cursor.next.next = temp;
			}
			cursor = temp;
		}
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
