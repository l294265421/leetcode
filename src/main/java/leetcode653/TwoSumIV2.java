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
public class TwoSumIV2 {
 
	public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }
	/**
	 * 对树中的每一个节点(curNode),遍历整棵树，寻找与之相加等于最初k的节点
	 * @param root
	 * @param curNode
	 * @param k
	 * @return
	 */
    public boolean helper(TreeNode root, TreeNode curNode, int k) {
        if (curNode == null) 
        	return false;
        return preorder(root, curNode, k - curNode.val) || helper(root, curNode.left, k) || helper(root, curNode.right, k);
    }
    public boolean preorder(TreeNode root, TreeNode curNode, int k) {
        if (root == null) 
        	return false;
        if (root != curNode && root.val == k) 
        	return true;
        return (root.val < k) ? preorder(root.right, curNode, k) : preorder(root.left, curNode, k);
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
		TwoSumIV2 twoSumIV = new TwoSumIV2();
		System.out.println(twoSumIV.findTarget(one, 9));
	}
}
