package global;

import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right
				+ "]";
	}
	
	public static TreeNode str2tree(String s) {
		String[] nodeStrs = s.substring(1, s.length() - 1).split(",");
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(nodeStrs[0]));
		queue.add(root);
		int index = 1;
		while (!queue.isEmpty()) {
			TreeNode head = queue.poll();
			if (index < nodeStrs.length) {
				if (!"null".equals(nodeStrs[index])) {
					head.left = new TreeNode(Integer.parseInt(nodeStrs[index]));
					queue.add(head.left);
				}
				index++;
			}
			if (index < nodeStrs.length) {
				if (!"null".equals(nodeStrs[index])) {
					head.right = new TreeNode(Integer.parseInt(nodeStrs[index]));
					queue.add(head.right);
				}
				index++;
			}
		}
		return root;
	}

}
