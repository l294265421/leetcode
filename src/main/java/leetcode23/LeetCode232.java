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
public class LeetCode232 {
	
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
		
	}
	
	public static void main(String[] args) {
		LeetCode232 leetCode23 = new LeetCode232();
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
