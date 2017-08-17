package leetcode637;

import java.util.LinkedList;
import java.util.List;

import global.TreeNode;

/**
 * 
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:

    The range of node's value is in the range of 32-bit signed integer.

 * @author liyuncong
 *
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        double sum = 0;
        int counter = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
			TreeNode current = queue.remove();
			if (current == null) {
				if (counter != 0) {
					result.add(sum / counter);
					sum = 0;
					counter = 0;
				}
				if (queue.isEmpty()) {
					break;
				} else {
					queue.add(null);
				}
			} else {
				sum += current.val;
				counter++;
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}
        return result;
    }
    
    public static void main(String[] args) {
		AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
		TreeNode one = new TreeNode(3);
		TreeNode two = new TreeNode(9);
		TreeNode three = new TreeNode(20);
		TreeNode four = new TreeNode(15);
		TreeNode five = new TreeNode(7);
		one.left = two;
		one.right = three;
		three.left = four;
		three.right = five;
		List<Double> result = averageOfLevelsInBinaryTree.averageOfLevels(one);
		for (Double double1 : result) {
			System.out.println(double1);
		}
	}
}
