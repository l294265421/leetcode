package leetcode25;

import global.ListNode;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
    	// 至少有两个元素才需要反转；反转至少两个元素的组才有意义
    	if (head == null || head.next == null || 
    			k < 2) {
			return head;
		}
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        
        ListNode pre = preHead;
        ListNode nowHead = head;
        boolean isContinue = true;
        int count = 0;
        while (isContinue) {
        	ListNode cursor = nowHead;
        	ListNode tail = nowHead;
			while (cursor != null && count != k) {
				count++;
				tail = cursor;
				cursor = cursor.next;
			}
			if (count != k) {
				break;
			} else {
				tail.next = null;
				ListNode newHead = reverse(nowHead);
				pre.next = newHead;
				nowHead.next = cursor;
				pre = nowHead;
				nowHead = cursor;
				count = 0;
			}
		}
        return preHead.next;
    }
    
    /**
     * 反转链表，并返回头节点
     * @param head 头节点
     * @return 反转后链表头节点
     */
    public ListNode reverse(ListNode head) {
    	// 新链表的第二个节点
		ListNode p = head;
		// 新链表的头节点
		ListNode q = head.next;
		head.next = null;
		// 旧链表的头节点
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
    
    public static void main(String[] args) {
		LeetCode25 leetCode25 = new LeetCode25();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		System.out.println(leetCode25.reverseKGroup(listNode1, 2));
	}
}
