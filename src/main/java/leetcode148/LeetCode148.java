package leetcode148;

import global.ListNode;

public class LeetCode148 {
	public ListNode sortList(ListNode head) {
	    return sortListInternal(head).head;
	}

	private SortedList sortListInternal(ListNode head) {
	    if (head == null || head.next == null) {
	        return new SortedList(head, head);
	    }

	    ListNode pivotHead = head;
	    head = head.next;
	    pivotHead.next = null;
	    ListNode pivotEnd = pivotHead;

	    ListNode lessHead = null;
	    ListNode lessTail = null;
	    ListNode greaterHead = null;
	    ListNode greaterTail = null;
	    while (head != null) {
	        ListNode tmp = head;
	        head = head.next;
	        tmp.next = null;
	        if (tmp.val == pivotHead.val) {
	            pivotEnd.next = tmp;
	            pivotEnd = pivotEnd.next;
	        } else if (tmp.val < pivotHead.val) {
	            if (lessHead == null) {
	                lessHead = lessTail = tmp;
	            } else {
	                lessTail.next = tmp;
	                lessTail = lessTail.next;
	            }
	        } else {
	            if (greaterHead == null) {
	                greaterHead = greaterTail = tmp;
	            } else {
	                greaterTail.next = tmp;
	                greaterTail = greaterTail.next;
	            }
	        }
	    }

	    if (lessHead == null && greaterHead == null) {
	        return new SortedList(pivotHead, pivotEnd);
	    }

	    SortedList sortedLess = sortListInternal(lessHead);
	    SortedList sortedGreater = sortListInternal(greaterHead);
	    if (lessHead == null) {
	        pivotEnd.next = sortedGreater.head;
	        return new SortedList(pivotHead, sortedGreater.tail);
	    } else if (greaterHead == null) {
	        sortedLess.tail.next = pivotHead;
	        return new SortedList(sortedLess.head, pivotEnd);           
	    } else {
	        sortedLess.tail.next = pivotHead;
	        pivotEnd.next = sortedGreater.head;
	        return new SortedList(sortedLess.head, sortedGreater.tail);
	    }
	}

	private static class SortedList {
	    ListNode head;
	    ListNode tail;

	    SortedList(ListNode h, ListNode t) {
	        head = h;
	        tail = t;
	    }
	}
    
}
