package leetcode655;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import global.TreeNode;

/**
 * 
Print a binary tree in an m*n 2D string array following these rules:

    The row number m should be equal to the height of the given binary tree.
    The column number n should always be an odd number.
    The root node's value (in string format) should be put in the exactly middle of 
    the first row it can be put. The column and the row where the root node belongs 
    will separate the rest space into two parts (left-bottom part and right-bottom 
    part). You should print the left subtree in the left-bottom part and print the 
    right subtree in the right-bottom part. The left-bottom part and the right-bottom 
    part should have the same size. Even if one subtree is none while the other is not,
     you don't need to print anything for the none subtree but still need to leave the 
     space as large as that for the other subtree. However, if two subtrees are none, 
     then you don't need to leave space for both of them.
    Each unused space should contain an empty string "".
    Print the subtrees following the same rules.

Example 1:

Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]

Example 2:

Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]

Example 3:

Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]

Note: The height of binary tree is in the range of [1, 10]. 
 * @author liyuncong
 *
 */
public class PrintBinaryTree {
	/**
	 * 1.每一个根节点，都放在相应区域的第一行的中间，并且从它的下一行到最后一行这片区域被平分为两部分
	 * @param root
	 * @return
	 */
    public List<List<String>> printTree(TreeNode root) {
        int height = height2(root);
        int columnNum = (int) (Math.pow(2, height) - 1);
        List<List<String>> result = new ArrayList<>(height);
        for(int i = 0; i < height; i++) {
        	List<String> row = new LinkedList<>();
        	for(int j = 0; j < columnNum; j++) {
        		row.add(j, "");
        	}
        	result.add(i, row);
        }
        printTree(root, result, 0, columnNum - 1, 0);
        return result;
    }
    
    private void printTree(TreeNode root, List<List<String>> result, int leftBound, 
    		int rightBound, int level) {
		int column = (leftBound + rightBound) / 2;
		result.get(level).set(column, Integer.toString(root.val));
		if (root.left != null) {
			printTree(root.left, result, leftBound, column - 1, level + 1);
		}
		if (root.right != null) {
			printTree(root.right, result, column + 1, rightBound, level + 1);
		}
	}
    
    private int height(TreeNode root) {
		int height = 0;
		if (root == null) {
			return height;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current == null) {
				height++;
				if (queue.isEmpty()) {
					break;
				} else {
					queue.add(null);
				}
			} else {
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}
		return height;
	}
    
    private int height2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height2(root.left), height2(root.right));
	}
    
    public static void main(String[] args) {
		PrintBinaryTree printBinaryTree = new PrintBinaryTree();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		one.left = two;
		one.right = three;
		two.right = four;
		List<List<String>> result = printBinaryTree.printTree(one);
		for (List<String> list : result) {
			System.out.println(list);
		}
	}
}
