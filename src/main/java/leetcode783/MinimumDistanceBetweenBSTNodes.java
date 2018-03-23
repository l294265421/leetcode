package leetcode783;

import java.util.Stack;

import global.TreeNode;

/**
 * 
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.

Note:

    The size of the BST will be between 2 and 100.
    The BST is always valid, each node's value is an integer, and each node's value is different.

 * @author liyuncong
 *
 */
public class MinimumDistanceBetweenBSTNodes {
	/**
	 * 中序遍历时记录连续的两个节点的差值
	 * @param root
	 * @return
	 */
    public int minDiffInBST(TreeNode root) {
        Stack<Boolean> accessedLeftChild = new Stack<>();
        Stack<TreeNode> helper = new Stack<>();
        helper.push(root);
        accessedLeftChild.push(false);
        int minDiff = Integer.MAX_VALUE;
        int lastValue  = 0;
        boolean first = true;
        while (!helper.isEmpty()) {
			boolean accessedLeft = accessedLeftChild.pop();
			if (!accessedLeft && helper.peek().left != null) {
				accessedLeftChild.push(true);
				helper.push(helper.peek().left);
				accessedLeftChild.push(false);
			} else {
				TreeNode currentNode = helper.pop();
				if (first) {
					lastValue = currentNode.val;
					first = false;
				} else {
					int temp = currentNode.val - lastValue;
					lastValue = currentNode.val;
					if (temp < minDiff) {
						minDiff = temp;
					}
				}
				if (currentNode.right != null) {
					accessedLeftChild.push(false);
					helper.push(currentNode.right);
				}
			}
		}
        return minDiff;
    }
    
    public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		MinimumDistanceBetweenBSTNodes minimumDistanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
		System.out.println(minimumDistanceBetweenBSTNodes.minDiffInBST(node1));
	}
}
