package leetcode138;

import global.RandomListNode;

/**
 * 
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
 * @author liyuncong
 *
 */
public class CopyListwithRandomPointer {
	private int NONE_RANDOM = -1;;
	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * };
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		/**
		 * 
		 * 1.把链表放进数组
		 * 2.确定每个节点的random在数组中的索引
		 * 3.复制数组，节点只复制了值
		 * 4.给每个节点设置next和random
		 */
		int count = 0;
		RandomListNode cursor = head;
		while (cursor != null) {
			count++;
			cursor = cursor.next;
		}
		
		if (count == 0) {
			return null;
		}
		
		RandomListNode[] arrayRepresentation = new RandomListNode[count];
		RandomListNode cursor1 = head;
		int i = 0;
		do {
			arrayRepresentation[i] = cursor1;
			cursor1 = cursor1.next;
			i++;
		} while (cursor1 != null);
		
		int[] randomListNodeIndex = new int[count];
		for(int j = 0; j < count; j++) {
			RandomListNode randomListNode = arrayRepresentation[j].random;
			if (randomListNode == null) {
				randomListNodeIndex[j] = NONE_RANDOM;
				continue;
			}
			for(int k = 0; k < count; k++) {
				if (randomListNode == arrayRepresentation[k]) {
					randomListNodeIndex[j] = k;
				}
			}
		}
		
		RandomListNode[] copy = new RandomListNode[count];
		for(int j = 0; j < count; j++) {
			copy[j] = new RandomListNode(arrayRepresentation[j].label);
		}
		for(int j = 0; j < count - 1; j++) {
			copy[j].next = copy[j + 1];
			if (randomListNodeIndex[j] != NONE_RANDOM) {
				copy[j].random = copy[randomListNodeIndex[j]];
			}
		}
		if (randomListNodeIndex[count - 1] != NONE_RANDOM) {
			copy[count - 1].random = copy[randomListNodeIndex[count - 1]];
		}
		return copy[0];
    }
	
	public static void main(String[] args) {
		CopyListwithRandomPointer copyListwithRandomPointer = new CopyListwithRandomPointer();
		RandomListNode randomListNode = new RandomListNode(-1);
		System.out.println(copyListwithRandomPointer.copyRandomList(randomListNode));
	}
}
