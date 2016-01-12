package leetcode236;

import java.util.LinkedList;
import java.util.List;

import global.TreeNode;

/**
 * 寻找到从root到p节点和q节点链表，链表中从头开始最后一个相等的就是
 * @author yuncong
 *
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
			return p;
		}
        List<TreeNode> path1 = findPath(root, p);
        int size1 = path1.size();
        if (size1 == 0) {
			return root;
		}
        List<TreeNode> path2 = findPath(root, q);
        int size2 = path2.size();
        if (size2 == 0) {
			return root;
		}
        int bound = Math.min(path1.size(),  path2.size()) - 1;
        for(int i = bound; i >= 0; i--) {
        	if (path1.get(i) == path2.get(i)) {
				return path1.get(i);
			}
        }
        return null;
    }
    
    /**
     * 寻找从root到node的路径；
     * 先根遍历；
     * 递归实现是这样的，遇到一个节点，先访问该节点，再访问左孩子，然后右孩子，只有一种情况
     * 函数会返回，右孩子访问完；
     * 利用栈实现（模拟递归），遇到一个节点，先访问，然后入栈，再访问左孩子，入栈，然后访问
     * 右孩子，然后入栈，一个元素在右孩子访问完了就弹栈
     * @param root
     * @param node
     * @return
     */
    public List<TreeNode> findPath(TreeNode root, TreeNode node) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		// 对应于stack中的元素被访问的状态，0，只有自己被访问，1，左孩子被访问，2，右孩子被访问
		LinkedList<Integer> assistant = new LinkedList<Integer>();
		if (root == node) {
			return stack;
		}
		stack.add(root);
		assistant.add(0);
		while (!stack.isEmpty()) {
			TreeNode thisNode = stack.peek();
			int state = assistant.peek();
			if (state == 0) {
				assistant.pop();
				assistant.add(1);
				TreeNode left = thisNode.left;
				if (left != null) {
					if (left == node) {
						// 找到了
						break;
					} else {
						stack.add(left);
						assistant.add(0);
					}
				}
			} else if (state == 1) {
				assistant.pop();
				assistant.add(2);
				TreeNode right = thisNode.right;
				if (right != null) {
					if (right == node) {
						return stack;
					} else {
						stack.add(right);
						assistant.add(0);
					}
				}
			} else {
				stack.pop();
				assistant.pop();
			}
		}
		return stack;
	}
    
    public static void main(String[] args) {
		LeetCode236 leetCode236 = new LeetCode236();
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.right = treeNode4;
		System.out.println(leetCode236.lowestCommonAncestor(treeNode1, treeNode3, treeNode4));
	}
}
