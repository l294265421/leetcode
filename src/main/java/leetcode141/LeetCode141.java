package leetcode141;

import java.util.HashSet;
import java.util.Set;

import global.ListNode;

/**
 * 
 * @author liyuncong
 *
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
    	boolean hasCycle = false;
    	if (head == null) {
			return hasCycle;
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
    			hasCycle = true;
    			return hasCycle;
    		} else if(cursor == null){
    			hasCycle = false;
    			return hasCycle;
    		} else {
    			visited.add(cursor);
    			cursor = cursor.next;
			}
		} while (isContinue); 
    	return hasCycle;
    }
}
