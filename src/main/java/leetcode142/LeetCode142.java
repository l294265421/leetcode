package leetcode142;

import java.util.HashSet;
import java.util.Set;

import global.ListNode;

/**
 * 
 * @author liyuncong
 *
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
    	ListNode cycleBegin = null;
    	if (head == null) {
			return cycleBegin;
		}
    	// 存储已经访问过的元素
    	Set<ListNode> visited = new HashSet<ListNode>();
    	visited.add(head);
        // 在遇到null指针或者head时结束；
    	// 遇到null表示不存在环，遇到head表示存在环
    	ListNode cursor = head.next;
    	boolean isContinue = true;
    	do {
        	if (visited.contains(cursor)) {
    			return cursor;
    		} else if(cursor == null){
    			return null;
    		} else {
    			visited.add(cursor);
    			cursor = cursor.next;
			}
		} while (isContinue); 
    	return null;
    }
}
