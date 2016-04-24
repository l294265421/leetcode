package leetcode102;

import global.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyuncong on 10/22/15.
 */
public class LeetCode1021 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) {
			return resultList;
		}
        
        List<Integer> levelStorage = new LinkedList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        while (queue.size() > 1) {
			TreeNode top = queue.poll();
			if (top == null) {
				resultList.add(levelStorage);
				queue.offer(null);
				levelStorage = new LinkedList<Integer>();
			} else {
				levelStorage.add(top.val);
				if (top.left != null) {
					queue.offer(top.left);
				}
				if (top.right != null) {
					queue.offer(top.right);
				}
			}
		}
        resultList.add(levelStorage);
        
        return resultList;
    }
}
