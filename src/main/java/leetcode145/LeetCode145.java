package leetcode145;

import java.util.LinkedList;
import java.util.List;

import global.TreeNode;

public class LeetCode145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNodeWithFlag> stack = new LinkedList<TreeNodeWithFlag>();
		// 首先，从根节点开始，往左下方走，一直走到头，将路径上的每一个结点入栈。
		TreeNode cursor1 = root;
		while (cursor1 != null) {
			stack.push(new TreeNodeWithFlag(cursor1, false));
			cursor1 = cursor1.left;
		}
		while (!stack.isEmpty()) {
			TreeNodeWithFlag top = stack.peek();
			// 注意，任意一个结点N，只要他有左孩子，则在N入栈之后，
			// N的左孩子必然也跟着入栈了(这个体现在算法的后半部分)，
			// 所以当我们拿到栈顶元素的时候，可以确信这个元素要么没有左孩子，
			// 要么其左孩子已经被访问过，所以此时我们就不关心它的左孩子了，我们只关心其右孩子。

			// 若其右孩子已经被访问过，或是该元素没有右孩子，则由后序遍历的定义，此时可以visit这个结点了。
			if (top.treeNode.right == null || top.flag == true) {
				stack.pop();
				result.add(top.treeNode.val);
			} else {
				// 若它的右孩子存在且top.flag为false，说明以前还没有动过它的右孩子，于是就去处理一下其右孩子。
				// 此时我们要从其右孩子结点开始一直往左下方走，直至走到尽头，将这条路径上的所有结点都入栈。

				// 当然，入栈之前要先将该结点的top.flag设成true，因为其右孩子的入栈
				// 意味着它的右孩子必将先于它被访问(这很好理解，因为我们总是从栈顶取出元素来进行visit)。
				// 由此可知，下一次该元素再处于栈顶时，其右孩子必然已被visit过了，所以此处可以将top.flag设置为true。
				top.flag = true;
				TreeNode cursor2 = top.treeNode.right;
				while (cursor2 != null) {
					stack.push(new TreeNodeWithFlag(cursor2, false));
					cursor2 = cursor2.left;
				}
			}

		}
		return result;
	}

	private static class TreeNodeWithFlag {
		private TreeNode treeNode;
		// 表示该节点的右子树是否被访问过
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
		LeetCode145 leetCode145 = new LeetCode145();
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		treeNode1.left = treeNode2;
		System.out.println(leetCode145.postorderTraversal(treeNode1));
	}
}
