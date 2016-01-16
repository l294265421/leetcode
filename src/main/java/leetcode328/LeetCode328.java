package leetcode328;

import global.ListNode;

public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        // 至少有三个元素才需要进一步操作
    	if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
    	ListNode lastOdd = head;
    	ListNode lastEven = head.next;
    	while (lastEven != null && lastEven.next != null) {
    		ListNode thisOdd = lastEven.next;
    		
    		// 后面删除奇位置的元素
    		lastEven.next = thisOdd.next;
    		lastEven = lastEven.next;
    		
    		// 前面插入奇位置的数
    		thisOdd.next = lastOdd.next;
    		lastOdd.next = thisOdd;
    		lastOdd = thisOdd;
		}
    	return head;
    }
    
    public static void main(String[] args) {
		LeetCode328 leetCode328 = new LeetCode328();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		System.out.println(leetCode328.oddEvenList(listNode1));
	}
}
