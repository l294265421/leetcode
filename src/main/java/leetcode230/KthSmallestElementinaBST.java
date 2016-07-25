package leetcode230;

import java.util.LinkedList;

import global.TreeNode;

/**
 * 
 Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author liyuncong
 * 
 */
public class KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return k;
		}
		
		int result = -1;
		LinkedList<TreeNodeWithFlag> helper = new LinkedList<>();
		helper.push(new TreeNodeWithFlag(root, false));
		int count = 0;
		while (!helper.isEmpty()) {
			TreeNodeWithFlag currentNode = helper.peek();
			if (currentNode.getTreeNode().left != null && !currentNode.leftChildIsVisited) {
				helper.push(new TreeNodeWithFlag(currentNode.getTreeNode().left, false));
				currentNode.setLeftChildIsVisited(true);
			} else {
				helper.pop();
				count++;
				if (count == k) {
					result = currentNode.getTreeNode().val;
					break;
				}
				if(currentNode.getTreeNode().right != null){
					helper.push(new TreeNodeWithFlag(currentNode.getTreeNode().right, false));
				}
			}
		}
		return result;
	}

	private static class TreeNodeWithFlag {
		private TreeNode treeNode;
		private boolean leftChildIsVisited;

		public TreeNodeWithFlag(TreeNode treeNode, boolean leftChildIsVisited) {
			super();
			this.treeNode = treeNode;
			this.leftChildIsVisited = leftChildIsVisited;
		}

		public TreeNode getTreeNode() {
			return treeNode;
		}

		public void setTreeNode(TreeNode treeNode) {
			this.treeNode = treeNode;
		}

		public boolean isLeftChildIsVisited() {
			return leftChildIsVisited;
		}

		public void setLeftChildIsVisited(boolean leftChildIsVisited) {
			this.leftChildIsVisited = leftChildIsVisited;
		}

		@Override
		public String toString() {
			return "TreeNodeWithFlag [treeNode=" + treeNode
					+ ", leftChildIsVisited=" + leftChildIsVisited + "]";
		}

	}
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(2);
		TreeNode treeNode2 = new TreeNode(1);
		treeNode.left = treeNode2;
		KthSmallestElementinaBST kthSmallestElementinaBST = new KthSmallestElementinaBST();
		System.out.println(kthSmallestElementinaBST.kthSmallest(treeNode, 1));
	}
}
