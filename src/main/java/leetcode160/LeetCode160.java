package leetcode160;

import global.ListNode;

/**
 * 把headB变成环，然后查看headA中是否有环
 * @author liyuncong
 *
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表中都有元素时，才可能有交点
    	if (headA == null || headB == null) {
			return null;
		}
    	
    	// 把headB变成环
    	// 记录headB的尾节点，用于之后把它恢复到修改之前的状态
    	ListNode tailB = null;
    	ListNode curserB = headB;
    	while (curserB != null) {
			tailB = curserB;
			curserB = curserB.next;
		}
    	tailB.next = headB;
    	
    	// 查看headA中是否有环
    	ListNode start = findLoopStart(headA);
    	tailB.next = null;
    	return start;
    }
    
    /**
     * 判断单链表中是否有环,如果存在就找到环起点
     * @param head 单链表头节点
     * @return 存在环就返回环起点，否则返回null
     */
    public ListNode findLoopStart(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		boolean isFindLoop = false;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			} else {
				break;
			}
			
			if (fast == slow) {
				isFindLoop = true;
				break;
			}
		}
		
		if (isFindLoop) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		} else {
			return null;
		}
	}
}
