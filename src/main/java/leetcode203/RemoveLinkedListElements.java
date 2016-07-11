package leetcode203;

import global.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) {
			return null;
		}
        return strategy2(head, val);
    }
    
    private ListNode strategy1(ListNode head, int val) {
		ListNode newHead = null;
		ListNode newTail = null;
		ListNode cursor = head;
		while (cursor != null) {
			if (cursor.val != val) {
				if (newHead == null) {
					newHead = new ListNode(cursor.val);
					newTail = newHead;
				} else {
					newTail.next = new ListNode(cursor.val);
					newTail = newTail.next;
				}
			}
			cursor = cursor.next;
		}
		return newHead;
	}
    
    private ListNode strategy2(ListNode head, int val) {
    	ListNode preHead = new ListNode(-1);
		preHead.next = head;
    	ListNode cursor = head;
		ListNode preCursor = preHead;
		while (cursor != null) {
			if (cursor.val == val) {
				cursor = cursor.next;
				preCursor.next = cursor;
			} else {
				preCursor = cursor;
				cursor = cursor.next;
			}
		}
		return preHead.next;
	}
    
    public static void main(String[] args) {
		RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		listNode.next = listNode2;
		System.out.println(removeLinkedListElements.removeElements(listNode, 1));
	}
}
