package leetcode147;

import global.ListNode;

public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
			return head;
		}
        ListNode preHead = new ListNode(-1);
        ListNode cursor = head;
        while (cursor != null) {
        	ListNode pre = preHead;
        	ListNode cursor1 = preHead.next;
        	boolean inserted = false;
			while (!inserted) {
				if (cursor1 == null) {
					pre.next = cursor;
					cursor = cursor.next;
					pre.next.next = null;
					inserted = true;
				} else {
					if (cursor1.val > cursor.val) {
						pre.next = cursor;
						cursor = cursor.next;
						pre.next.next = cursor1;
						inserted = true;
					} else {
						pre = pre.next;
						cursor1 = cursor1.next;
					}
				}
			}
		}
        return preHead.next;
    }
    
    public static void main(String[] args) {
		LeetCode147 leetCode147 = new LeetCode147();
		ListNode leListNode1 = new ListNode(1);
		ListNode leListNode2 = new ListNode(1);
		leListNode1.next = leListNode2;
		System.out.println(leetCode147.insertionSortList(leListNode1));
	}
}
