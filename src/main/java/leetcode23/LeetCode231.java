package leetcode23;

import java.util.LinkedList;
import java.util.List;

import global.ListNode;
import global.TreeNode;

/**
 * 就像把几堆有序扑克排序，每次从堆顶中选出一张最小的，直到没有元素位置
 * @author yuncong
 *
 */
public class LeetCode231 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		int size = lists.length;
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			return lists[0];
		}
		
		ListNode head = null;
		ListNode cursor = null;
		
		int nullCount = 0;
		for (ListNode listNode : lists) {
			if (listNode == null) {
				nullCount++;
			}
		}
		while (nullCount != size) {
			nullCount = 0;
			
			int start = 0;
			while (start < size && lists[start] == null) {
				start++;
				nullCount++;
			}
			
			ListNode minListNode = lists[start];
			int minIndex = start;
			for (int i = start + 1; i < size; i++) {
				if (lists[i] != null) {
					if (lists[i].val < minListNode.val) {
						minListNode = lists[i];
						minIndex = i;
					}
				} else {
					nullCount++;
				}
			}
			
			if (cursor == null) {
				head = minListNode;
				cursor = minListNode;
				lists[minIndex] = lists[minIndex].next;
				if (lists[minIndex] == null) {
					nullCount++;
				}
			} else {
				cursor.next = minListNode;
				lists[minIndex] = lists[minIndex].next;
				if (lists[minIndex] == null) {
					nullCount++;
				}
				cursor = cursor.next;
				cursor.next = null;
			}
		}
		return head;
		
	}
	
	public static void main(String[] args) {
		LeetCode231 leetCode23 = new LeetCode231();
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
