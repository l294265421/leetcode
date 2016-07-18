package leetcode99;

import java.util.LinkedList;
import java.util.List;

import global.TreeNode;

/**
 * 
 Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. Note: A solution using O(n)
 * space is pretty straight forward. Could you devise a constant space solution?
 * 
 * @author liyuncong
 * 
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		strategy1(root);
	}

	/**
	 * 中根遍历，得到元素集合，交换位置不对的两个元素的值
	 * 
	 * @param root
	 */
	public void strategy1(TreeNode root) {
		if (root == null) {
			return;
		}
		
		List<TreeNode> nodes = inOrderTraversal(root);
		if (nodes.size() == 1) {
			return;
		}
		TreeNode node1 = null;
		TreeNode node2 = null;
		for(int i = 1; i < nodes.size(); i++) {
			// 交换后，前面的数变大了,后面的数变小了；后面变小可能出现两次（非临近交换），这时，要用后面的一次覆盖前面的一次
			if (node1 == null && nodes.get(i).val < nodes.get(i - 1).val) {
				node1 = nodes.get(i - 1);
			} 
			if(node1 != null && nodes.get(i).val < nodes.get(i - 1).val){
				node2 = nodes.get(i);
			}
		}
		
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
	}

	public List<TreeNode> inOrderTraversal(TreeNode root) {
		List<TreeNode> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNodeWrapper> stack = new LinkedList<>();
		stack.add(new TreeNodeWrapper(root));
		while (!stack.isEmpty()) {
			TreeNodeWrapper currentNode = stack.peek();
			if (currentNode.getNode().left == null || currentNode.leftChildIsVisited) {
				result.add(currentNode.getNode());
				stack.pop();
				if (currentNode.getNode().right != null) {
					stack.push(new TreeNodeWrapper(currentNode.getNode().right));
				}
			} else {
				currentNode.setLeftChildIsVisited(true);
				stack.push(new TreeNodeWrapper(currentNode.getNode().left));
			}
		}
		return result;
	}

	private static class TreeNodeWrapper {
		private TreeNode node;
		private boolean leftChildIsVisited;

		public TreeNodeWrapper(TreeNode node) {
			super();
			this.node = node;
		}

		public TreeNode getNode() {
			return node;
		}

		public void setNode(TreeNode node) {
			this.node = node;
		}

		public boolean isLeftChildIsVisited() {
			return leftChildIsVisited;
		}

		public void setLeftChildIsVisited(boolean leftChildIsVisited) {
			this.leftChildIsVisited = leftChildIsVisited;
		}

		@Override
		public String toString() {
			return "TreeNodeWrapper [node=" + node + ", leftChildIsVisited="
					+ leftChildIsVisited + "]";
		}
		
	}
	
	public static void main(String[] args) {
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(3);
		root.left = left;
		TreeNode right = new TreeNode(1);
		root.right = right;
		
		recoverBinarySearchTree.recoverTree(root);
		
		List<TreeNode> nodes = recoverBinarySearchTree.inOrderTraversal(root);
		for (TreeNode treeNode : nodes) {
			System.out.println(treeNode.val);
		}
	}
}
