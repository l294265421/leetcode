package leetcode234;

import global.ListNode;

/**
 * 
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author liyuncong
 *
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
			return true;
		}
        
        int count = 1;
        ListNode cursor = head.next;
        while (cursor != null) {
			count++;
			cursor = cursor.next;
		}
        if (count == 1) {
			return true;
		}
        ListNode[] helper = new ListNode[count];
        ListNode current = head;
        for(int i = 0; i < count; i++) {
        	helper[i] = current;
        	current = current.next;
        }
        boolean result = true;
        for(int i = 0, j = count - 1; i < j; i++, j--) {
        	if (helper[i].val != helper[j].val) {
				result = false;
				break;
			}
        }
        return result;
    }
}
