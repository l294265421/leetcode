package leetcode257;

import global.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *  
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]
 * @author liyuncong
 *
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
			return result;
		}
        
        if (root.left == null && root.right == null) {
        	result.add(String.valueOf(root.val));
		} else if (root.left == null) {
			result.addAll(binaryTreePaths(root.right, String.valueOf(root.val)));
		} else if (root.right == null) {
			result.addAll(binaryTreePaths(root.left, String.valueOf(root.val)));
		} else {
			result.addAll(binaryTreePaths(root.left, String.valueOf(root.val)));
			result.addAll(binaryTreePaths(root.right, String.valueOf(root.val)));
		}
        
		return result;
    }
    
    public List<String> binaryTreePaths(TreeNode root, String prefix) {
    	List<String> result = new LinkedList<>();
        if (root.left == null && root.right == null) {
        	result.add(prefix + "->" + String.valueOf(root.val));
		} else if (root.left == null) {
			result.addAll(binaryTreePaths(root.right, prefix + "->" + String.valueOf(root.val)));
		} else if (root.right == null) {
			result.addAll(binaryTreePaths(root.left, prefix + "->" + String.valueOf(root.val)));
		} else {
			result.addAll(binaryTreePaths(root.right, prefix + "->" + String.valueOf(root.val)));
			result.addAll(binaryTreePaths(root.left, prefix + "->" + String.valueOf(root.val)));
		}
        
		return result;
	}
    
    public static void main(String[] args) {
		LeetCode257 leetCode257 = new LeetCode257();
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode5 = new TreeNode(5);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.right = treeNode5;
		System.out.println(leetCode257.binaryTreePaths(treeNode1));
	}
}
