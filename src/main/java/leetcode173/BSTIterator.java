package leetcode173;

import java.util.ArrayList;
import java.util.List;

import global.TreeNode;

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * 
 * 1.压平
 * 2.移动
 */
public class BSTIterator {
	private List<TreeNode> flatTree = new ArrayList<TreeNode>();
	private int cursor;
	private int size;
    public BSTIterator(TreeNode root) {
        inOrderTraversal(root, flatTree);
        size = flatTree.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cursor < size;
    }

    /** @return the next smallest number */
    public int next() {
        return flatTree.get(cursor++).val;
    }
    
    public void inOrderTraversal(TreeNode root, List<TreeNode> flatTree) {
		if (root != null) {
			inOrderTraversal(root.left, flatTree);
			flatTree.add(root);
			inOrderTraversal(root.right, flatTree);
		}
	}
}
