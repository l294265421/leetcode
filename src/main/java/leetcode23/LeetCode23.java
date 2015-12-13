package leetcode23;

import global.ListNode;

public class LeetCode23 {
	public ListNode mergeKLists(ListNode[] lists) {
		int size = lists.length;
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			return lists[0];
		}
		ListNode result = lists[0];
		for(int i = 1; i < size; i++) {
			result = mergeTwoLists(result, lists[i]);
		}
		return result;
	}

	/**
	 * 使用插入排序，将listNode2中元素插入listNode1中；
	 * 
	 * @param listNode1
	 * @param listNode2
	 */
	public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
		if (listNode1 == null) {
			return listNode2;
		}
		ListNode head = new ListNode(-1);
		head.next = listNode1;
		ListNode cursor = listNode1;
		ListNode cursorParent = head;
		while (listNode2 != null) {
		if (cursor != null) {
			if (listNode2.val < cursor.val) {
				cursorParent.next = listNode2;
				listNode2 = listNode2.next;
				cursorParent.next.next = cursor;
				cursorParent = cursorParent.next;
			} else {
				cursor = cursor.next;
				cursorParent = cursorParent.next;
			}
		} else {
			cursorParent.next = listNode2;
			break;
		}
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		LeetCode23 leetCode23 = new LeetCode23();
		ListNode listNode1 = new ListNode(0);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(2);
		ListNode[] lists = new ListNode[3];
		lists[0] = listNode1;
		lists[1] = listNode2;
		lists[2] = listNode3;
		System.out.println(leetCode23.mergeKLists(lists));
	}
}
