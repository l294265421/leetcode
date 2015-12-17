package leetcode23;

import java.util.LinkedList;
import java.util.List;

import global.ListNode;
import global.TreeNode;

/**
 * 就像把几堆有序扑克排序，每次从所有堆顶中选出一张最小的，直到没有元素位置
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
		 
		// 1.把所有非null元素移到数组左边
		int rightIndexOfNoneNull = -1;
		for(int i = 0; i < size; i++) {
			if (lists[i] != null) {
				rightIndexOfNoneNull++;
				ListNode temp = lists[i];
				lists[i] = lists[rightIndexOfNoneNull];
				lists[rightIndexOfNoneNull] = temp;
			}
		}
		
		if (rightIndexOfNoneNull == -1) {
			return null;
		}
		if (rightIndexOfNoneNull == 0) {
			return lists[0];
		}
		
		// 2. 建小根堆
		int heapLength = rightIndexOfNoneNull + 1;
		buildMinHeap(lists, heapLength);
		
		ListNode preHead = new ListNode(-1);
		ListNode cursor = preHead;
		while (heapLength != 0) {
			// 3. 获取堆顶元素的头元素， 插入排序队列最后
			ListNode heapTop = lists[0];
			lists[0] = lists[0].next;
			heapTop.next = null;
			cursor.next = heapTop;
			cursor = cursor.next;
			// 4. 如果堆顶元素变为null，就与堆的最后一个元素互换，然后下沉该元素，否则
			// 直接下沉堆顶元素
			if (lists[0] == null) {
				lists[0] = lists[heapLength - 1];
				heapLength--;
				minHeapify(lists, 0, heapLength);
			} else {
				minHeapify(lists, 0, heapLength);
			}
		}
		return preHead.next;
	}
	
	/**
	 * 保持堆得性质
	 * @param lists 保存堆的数组
	 * @param i 堆中需要下降的元素
	 * @param heapLength 堆的长度
	 */
	public void minHeapify(ListNode[] lists, int i, int heapLength) {
		int l = left(i);
		int r = right(i);
		int minimum = -1;
		if (l < heapLength && lists[l].val < lists[i].val) {
			minimum = l;
		} else {
			minimum = i;
		}
		
		if (r < heapLength && lists[r].val < lists[minimum].val) {
			minimum = r;
		}
		if (i != minimum) {
			ListNode temp = lists[i];
			lists[i] = lists[minimum];
			lists[minimum] = temp;
			minHeapify(lists, minimum, heapLength);
		}
	}
	
	/**
	 * 建堆
	 * @param lists 保存堆的数组
	 * @param heapLength 堆的长度
	 */
	public void buildMinHeap(ListNode[] lists, int heapLength) {
		//拥有子节点的最大下标
		int start = parent(heapLength - 1);
		for(int i = start; i >= 0; i--) {
			minHeapify(lists, i, heapLength);
		}
	}
	
	private int left(int i) {
		return i * 2 + 1;
	}
	
	private int right(int i) {
		return i * 2 + 2;
	}
	
	private int parent(int i) {
		if (i == 0) {
			return 0;
		}
		if (i % 2 == 0) {
			return i / 2 - 1;
		} else {
			return i / 2;
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
