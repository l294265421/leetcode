package leetcode653;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import global.TreeNode;

/**
 * 
Given a Binary Search Tree and a target number, return true if there exist two 
elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

 * @author liyuncong
 *
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
    	int[] sortedArray = toSortedArray(root);
    	int left = 0;
    	int right = sortedArray.length - 1;
    	while (left < right) {
			int target = k - sortedArray[left];
			right = binarySearch(sortedArray, false, target, left, right);
			if (left >= right) {
				return false;
			}
			if (target == sortedArray[right]) {
				return true;
			}
			target = k - sortedArray[right];
			left = binarySearch(sortedArray, true, target, left, right);
			if (left >= right) {
				return false;
			}
			if (target == sortedArray[left]) {
				return true;
			}
		}
        return false;
    }
    
    private int binarySearch(int[] sortedArray, boolean larger, int target, int left, int right) {
		int start = left;
		int end = right;
    	while (start <= end) {
			int mid = (start + end) / 2;
			if (sortedArray[mid] == target) {
				return mid;
			} else if (target > sortedArray[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
    	int mid = (start + end) / 2;
    	return larger ? mid + 1 : mid;
	}
    
    private int[] toSortedArray(TreeNode root) {
    	List<Integer> vals = new ArrayList<>();
    	LinkedList<TreeNodeWithLeftChildAccessFlag> stack = new LinkedList<>();
    	stack.push(new TreeNodeWithLeftChildAccessFlag(root));
    	while (!stack.isEmpty()) {
			TreeNodeWithLeftChildAccessFlag current = stack.peek();
			if (!current.isAccessedLeftChild()) {
				if (current.getNode().left != null) {
					stack.push(new TreeNodeWithLeftChildAccessFlag(current.node.left));
				}
				current.setAccessedLeftChild(true);
			} else {
				vals.add(current.node.val);
				stack.pop();
				if (current.node.right != null) {
					stack.push(new TreeNodeWithLeftChildAccessFlag(current.node.right));
				}
			}
		}
    	int[] result = new int[vals.size()];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = vals.get(i);
    	}
    	return result;
    }
    
    private static class TreeNodeWithLeftChildAccessFlag {
    	private TreeNode node;
    	private boolean accessedLeftChild;
		public TreeNodeWithLeftChildAccessFlag(TreeNode node) {
			super();
			this.node = node;
		}
		public TreeNode getNode() {
			return node;
		}
		public void setNode(TreeNode node) {
			this.node = node;
		}
		public boolean isAccessedLeftChild() {
			return accessedLeftChild;
		}
		public void setAccessedLeftChild(boolean accessedLeftChild) {
			this.accessedLeftChild = accessedLeftChild;
		}
		@Override
		public String toString() {
			return "TreeNodeWithLeftChildAccessFlag [node=" + node + ", accessedLeftChild=" + accessedLeftChild + "]";
		}
    }
    
    public static void main(String[] args) {
		TreeNode one = new TreeNode(5);
		TreeNode two = new TreeNode(3);
		TreeNode three = new TreeNode(6);
		TreeNode four = new TreeNode(2);
		TreeNode five = new TreeNode(4);
		TreeNode six = new TreeNode(7);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.right = six;
		TwoSumIV twoSumIV = new TwoSumIV();
		System.out.println(twoSumIV.findTarget(one, 9));
	}
}
