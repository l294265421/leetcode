package leetcode94;

import global.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode941 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<Integer>();
		if (root == null) {
			return resultList;
		}
		LinkedList<TreeNodeWithFlag> stack = new LinkedList<>();
		stack.push(new TreeNodeWithFlag(root, false));
		while (!stack.isEmpty()) {
			TreeNodeWithFlag temp = stack.peek();
			if (temp.getTreeNode().left != null && !temp.flag) {
				stack.push(new TreeNodeWithFlag(temp.getTreeNode().left, false));
				// 当temp再次处于栈顶时，它的左子树必定已经被访问过了
				temp.setFlag(true);
			} else {
				resultList.add(temp.getTreeNode().val);
				stack.pop();
				if (temp.getTreeNode().right != null) {
					stack.push(new TreeNodeWithFlag(temp.getTreeNode().right, false));
				}
			}
		}
		
		return resultList;
	}
	
	private static class TreeNodeWithFlag {
		private TreeNode treeNode;
		// 表示该节点的左子树是否被访问过
		private boolean flag;

		private TreeNodeWithFlag(TreeNode treeNode, boolean flag) {
			super();
			this.treeNode = treeNode;
			this.flag = flag;
		}

		public TreeNode getTreeNode() {
			return treeNode;
		}

		public void setTreeNode(TreeNode treeNode) {
			this.treeNode = treeNode;
		}

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		@Override
		public String toString() {
			return "TreeNodeWithFlag [treeNode=" + treeNode + ", flag=" + flag
					+ "]";
		}

	}
	
	public static void main(String[] args) {
		LeetCode941 leetCode94 = new LeetCode941();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		one.right = two;
		TreeNode three = new TreeNode(3);
		two.left = three;
		System.out.println(leetCode94.inorderTraversal(one));
	}
}
