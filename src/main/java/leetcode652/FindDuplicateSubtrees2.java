package leetcode652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import global.TreeNode;
import leetcode652.FindDuplicateSubtrees.TreeNodeWithParent;

/**
 * 
Given a binary tree, return all duplicate subtrees. For each kind of duplicate 
subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4

The following are two duplicate subtrees:

      2
     /
    4

and

    4

Therefore, you need to return above trees' root in the form of a list. 
 * @author liyuncong
 *
 */
public class FindDuplicateSubtrees2 {
	private static Map<Pair, Boolean> pairs = new HashMap<>();
	/**
	 * 两个树相等 = 两个树有相等的结构和相同的节点值 => 有相同的层数
	 * => 将所有子树按层数分类
	 * 两个树相等 => 它们的子树也要相等
	 * @param root
	 * @return
	 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	if (root == null) {
			return new LinkedList<>();
		}
    	Set<TreeNodeWithParent> duplicates = new HashSet<>();
    	List<TreeNodeWithParent> subtrees = new ArrayList<>();
    	wrapAndFindLeaf(root, null, subtrees);
    	while (subtrees.size() > 1) {
    		Map<TreeNodeWithParent, Integer> temp = new HashMap<>();
    		Set<TreeNodeForFindParent> parents = new HashSet<>();
        	for(int i = 0; i < subtrees.size(); i++) {
        		TreeNodeWithParent nodei = subtrees.get(i);
        		if (nodei.parent != null) {
        			parents.add(new TreeNodeForFindParent(nodei.parent));
				}
        		Integer count = temp.get(nodei);
        		if (count == null) {
					count = 0;
				}
        		temp.put(nodei, count + 1);
        	}
        	for (Entry<TreeNodeWithParent, Integer> duplicate : temp.entrySet()) {
    			if (duplicate.getValue() > 1) {
    				duplicates.add(duplicate.getKey());
    			}
    		}
        	subtrees.clear();
        	for(TreeNodeForFindParent treeNodeForFindParent : parents) {
        		subtrees.add(treeNodeForFindParent.treeNodeWithParent);
        	}
		}
    	List<TreeNode> result = new LinkedList<>();
    	for (TreeNodeWithParent duplicate : duplicates) {
			result.add(duplicate.node);
		}
		return result;
    }
    
    private static boolean duplicate(TreeNode first, TreeNode second) {
    	if (first == null && second == null) {
			return true;
		}
    	if (first == null || second == null) {
			return false;
		}
    	Pair pair = new Pair(first, second);
		Boolean result = pairs.get(pair);
		if (result == null) {
			result = first.val == second.val;
			if (result) {
				result = duplicate(first.left, second.left);
				if (result) {
					result = duplicate(first.right, second.right);
				}
			}
			pairs.put(pair, result);
		}
		return result;
	}
    
    private TreeNodeWithParent wrapAndFindLeaf(TreeNode root, TreeNodeWithParent parent, List<TreeNodeWithParent> leaves) {
		TreeNodeWithParent result = new TreeNodeWithParent();
		result.setNode(root);
		result.setParent(parent);
		boolean isLeaf = true;
		if (root.left != null) {
			result.plusChildNum(1);
			wrapAndFindLeaf(root.left, result, leaves);
			isLeaf = false;
		}
		if (root.right != null) {
			result.plusChildNum(1);
			wrapAndFindLeaf(root.right, result, leaves);
			isLeaf = false;
		}
		if (isLeaf) {
			leaves.add(result);
		}
		return result;
	}
    
    private static class Pair{
    	private TreeNode first;
    	private TreeNode second;
		public Pair(TreeNode first, TreeNode second) {
			super();
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((first == null) ? 0 : first.hashCode());
			result = prime * result + ((second == null) ? 0 : second.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			Pair other = (Pair) obj;
			return this.first == other.first && this.second == other.second;
		}

		@Override
		public String toString() {
			return "Pair [first=" + first.val + ", second=" + second.val + "]";
		}
    	
    }
    
    public static class TreeNodeWithParent{
    	private TreeNode node;
    	private TreeNodeWithParent parent;
    	private int childNum = 0;
		public TreeNode getNode() {
			return node;
		}
		public void setNode(TreeNode node) {
			this.node = node;
		}
		public TreeNodeWithParent getParent() {
			return parent;
		}
		public void setParent(TreeNodeWithParent parent) {
			this.parent = parent;
		}
		public int getChildNum() {
			return childNum;
		}
		public void setChildNum(int childNum) {
			this.childNum = childNum;
		}
		public void plusChildNum(int childNum) {
			this.childNum += childNum;
			if (parent != null) {
				parent.plusChildNum(childNum);
			}
		}
		
		@Override
		public String toString() {
			return "TreeNodeWithParent [node=" + node.val + ", childNum=" + childNum + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + childNum;
			result = prime * result + ((node == null) ? 0 : node.val);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			TreeNodeWithParent other = (TreeNodeWithParent) obj;
			if (this.childNum == other.childNum && duplicate(node, other.node)) {
				return true;
			}
			return false;
		}
    }
    
    private static class TreeNodeForFindParent{
    	private TreeNodeWithParent treeNodeWithParent;

		public TreeNodeForFindParent(TreeNodeWithParent treeNodeWithParent) {
			super();
			this.treeNodeWithParent = treeNodeWithParent;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((treeNodeWithParent == null) ? 0 : treeNodeWithParent.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			TreeNodeForFindParent other = (TreeNodeForFindParent) obj;
			return treeNodeWithParent.node == other.treeNodeWithParent.node;
		}


		@Override
		public String toString() {
			return "TreeNodeForFindParent [treeNodeWithParent=" + treeNodeWithParent + "]";
		}
    }
    
    public static void main(String[] args) {
//		TreeNode one = new TreeNode(1);
//		TreeNode two = new TreeNode(2);
//		TreeNode three = new TreeNode(3);
//		TreeNode four = new TreeNode(4);
//		TreeNode five = new TreeNode(2);
//		TreeNode six = new TreeNode(4);
//		TreeNode seven = new TreeNode(4);
//		one.left = two;
//		one.right = three;
//		two.left = four;
//		three.left = five;
//		three.right = six;
//		five.left = seven;
    	String s = "[94,93,95,92,94,96,94,93,93,93,95,97,97,95,95,92,94,94,94,92,94,94,96,98,98,96,98,96,94,94,96,91,91,93,95,93,95,95,95,91,93,93,95,95,93,97,97,97,97,97,99,95,97,97,99,95,97,93,95,null,95,95,95,90,92,90,92,92,94,94,96,94,null,96,94,94,94,96,null,90,92,null,null,94,null,94,96,null,null,null,null,96,null,null,null,96,98,96,96,96,96,100,100,94,94,98,96,96,96,98,100,94,96,98,98,94,94,94,96,null,null,94,96,94,94,89,91,null,93,91,91,91,91,null,91,null,null,null,null,null,null,93,95,95,95,93,95,null,null,95,93,null,null,null,null,null,93,null,95,93,95,null,97,95,97,95,95,97,99,97,97,null,97,95,null,95,97,101,101,99,99,95,null,93,null,97,99,95,97,97,97,95,95,99,97,101,99,93,93,95,97,97,99,99,null,null,null,null,95,95,95,97,95,null,null,95,null,null,95,null,null,88,88,92,null,null,94,90,92,92,92,90,90,90,92,90,92,null,null,null,94,94,96,null,null,null,94,null,null,null,null,94,null,null,null,94,null,null,null,96,null,96,96,94,94,null,null,null,96,96,94,96,96,100,100,96,98,96,96,null,96,94,null,94,96,null,null,100,102,100,null,null,100,98,98,94,96,92,94,96,98,98,98,94,94,96,98,96,98,96,98,null,96,96,94,98,98,96,98,100,102,98,null,92,94,92,94,96,null,null,null,96,98,98,100,100,100,94,96,94,null,null,96,96,98,null,null,null,null,96,94,null,null,87,89,91,null,null,null,89,89,null,91,93,93,null,93,89,91,89,91,91,89,93,null,91,null,null,null,null,93,null,null,null,null,null,null,null,null,null,null,null,null,null,95,97,null,95,null,null,95,95,97,95,97,95,null,95,95,97,97,101,101,101,101,95,95,97,99,95,null,95,97,97,null,95,null,93,95,null,null,null,null,101,103,99,null,null,101,null,null,null,null,null,93,97,97,null,91,null,95,97,97,97,null,97,null,97,99,95,95,93,null,null,97,97,null,95,null,null,99,95,97,97,99,95,97,95,97,93,95,99,97,97,99,95,97,97,99,99,99,101,101,null,99,91,null,null,null,null,null,null,93,null,97,95,95,97,null,97,97,101,99,null,99,99,null,null,null,97,97,null,null,null,null,97,97,null,null,null,95,null,null,null,null,null,null,null,null,null,null,null,null,92,null,null,null,null,null,null,94,88,null,null,null,90,90,null,null,null,null,88,88,null,null,null,90,null,null,null,null,null,null,null,null,96,96,96,96,96,96,96,94,null,null,96,96,94,null,94,96,96,null,98,96,100,102,null,null,102,102,null,100,94,96,94,null,96,98,98,null,94,96,96,null,98,null,null,null,96,94,null,null,null,94,null,null,null,104,null,100,null,102,null,null,96,96,96,96,null,92,null,96,null,96,null,null,96,null,null,null,null,null,98,null,null,null,94,94,null,null,null,98,null,96,null,null,100,null,96,96,96,98,96,98,98,100,94,null,null,null,null,null,null,98,94,92,96,96,null,100,96,null,98,null,98,100,94,94,96,98,null,96,98,100,98,98,100,100,102,100,100,null,null,null,null,92,92,null,null,null,96,94,null,96,98,98,96,98,96,null,102,null,98,null,null,null,100,100,null,null,null,null,96,98,96,98,null,94,null,null,95,null,87,null,null,91,91,91,87,null,null,89,91,null,null,null,null,null,null,null,null,null,97,95,95,97,null,null,null,null,97,95,null,null,93,null,95,93,null,null,95,null,97,99,95,95,99,null,null,103,101,null,null,103,null,99,95,95,null,95,95,93,null,97,null,null,null,null,93,95,95,97,null,null,null,null,97,null,null,null,null,null,null,null,101,null,101,103,97,97,95,null,null,null,null,97,null,null,95,null,null,null,null,97,null,null,93,93,null,null,97,null,null,null,99,null,95,95,null,null,97,95,null,null,95,null,97,null,97,99,99,null,null,null,null,99,93,95,91,93,97,97,95,95,101,99,null,null,null,null,99,null,null,null,93,null,93,95,97,95,97,99,95,95,97,99,99,101,97,null,null,99,99,99,null,null,103,103,101,101,null,101,null,93,null,91,null,95,null,95,null,97,99,99,97,99,97,97,97,null,95,95,null,null,null,97,101,99,99,101,null,null,null,null,95,null,null,null,93,null,null,null,null,88,null,null,null,null,null,null,null,null,88,null,90,92,null,null,94,96,null,null,96,96,98,null,96,96,null,null,94,96,92,null,94,null,96,98,100,100,null,96,94,null,null,null,102,null,null,null,null,102,null,null,94,94,94,96,null,96,null,null,92,94,96,null,94,null,94,94,null,96,null,98,null,null,null,100,100,102,null,null,98,null,96,98,null,null,null,null,null,null,null,null,94,94,null,94,null,null,null,null,94,96,96,96,96,96,null,96,null,null,96,96,98,98,null,100,98,100,null,null,null,94,94,96,92,92,92,94,null,98,null,98,94,96,94,96,null,null,null,100,null,null,92,null,92,94,null,96,98,96,96,null,98,98,98,null,96,null,96,96,null,null,null,100,98,null,null,100,96,98,null,null,98,98,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,96,96,98,null,null,100,100,96,98,100,98,null,null,96,98,98,98,96,null,94,null,null,null,null,100,98,null,100,null,null,102,null,null,null,null,null,null,87,null,null,null,null,null,95,95,null,97,null,null,null,97,97,null,95,97,95,97,95,null,null,null,null,null,null,null,95,null,null,null,null,null,null,101,97,null,93,null,null,null,null,103,null,null,95,null,95,93,95,95,95,null,null,93,null,93,null,null,null,null,95,95,null,null,95,97,97,99,null,null,null,null,103,null,null,null,95,95,99,null,93,null,null,null,null,null,93,95,97,95,95,97,null,97,97,null,95,null,null,null,null,null,95,97,99,97,97,99,null,null,99,97,101,null,95,null,null,93,97,97,91,93,91,93,93,91,93,93,null,null,99,97,93,93,95,97,93,null,null,95,null,null,null,93,91,93,95,95,95,97,null,null,null,null,null,null,99,null,null,null,null,null,97,null,95,null,null,null,null,null,99,null,null,null,95,95,null,97,97,null,99,99,95,null,null,null,null,null,null,101,99,null,95,95,null,null,null,null,97,99,null,95,99,null,97,null,null,null,97,null,null,null,101,null,99,null,null,null,103,null,null,null,null,null,94,94,null,null,null,null,null,98,94,94,null,null,null,null,96,null,96,null,null,96,null,102,null,98,null,null,null,null,null,null,null,null,94,94,null,94,96,94,null,null,null,null,null,null,null,94,94,null,null,null,null,null,null,null,null,100,null,null,96,94,null,96,null,null,null,null,94,null,null,null,null,96,null,null,94,null,null,96,null,null,96,null,null,null,null,null,96,null,null,null,96,96,null,98,null,null,98,null,null,null,null,102,null,null,92,94,96,null,96,96,null,90,null,null,92,92,null,92,92,null,null,92,null,92,94,92,null,100,96,null,94,null,null,94,96,null,98,null,92,94,94,96,null,null,92,90,null,null,94,null,94,96,94,96,98,96,null,null,null,null,94,96,null,null,94,null,94,94,null,null,null,98,98,null,null,100,null,null,null,102,null,null,96,null,null,96,null,null,null,null,96,null,100,null,null,null,null,null,null,102,null,null,104,104,null,null,null,null,null,97,null,95,95,null,95,97,null,null,95,null,null,103,null,97,95,95,null,null,93,93,null,null,null,95,null,null,null,93,null,null,97,null,93,null,null,null,null,null,95,null,null,null,null,null,null,null,95,97,95,null,95,null,97,99,null,null,null,null,91,93,null,95,null,null,null,97,95,null,89,null,null,91,null,null,null,null,null,null,null,null,91,null,93,95,93,91,null,null,95,null,93,null,95,null,null,null,null,null,null,93,null,null,null,95,null,null,null,null,89,null,null,95,null,null,95,null,95,93,null,null,null,97,95,null,null,null,95,null,null,null,null,95,null,95,99,null,97,null,null,null,null,103,95,null,95,null,null,97,null,null,null,null,null,null,null,null,null,null,null,96,94,null,null,null,98,null,null,null,104,null,null,null,null,null,null,null,null,null,94,94,null,null,null,94,null,98,94,null,null,96,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,94,null,null,null,null,null,null,null,null,null,92,null,null,null,null,94,null,94,null,92,null,94,92,94,94,96,94,92,null,null,null,null,94,94,null,null,96,null,92,null,96,null,null,null,null,null,null,null,94,null,null,null,96,null,null,102,null,null,null,null,null,null,null,null,null,null,null,null,null,null,93,null,93,null,null,null,99,null,null,null,null,null,null,null,null,null,null,null,null,null,null,91,null,null,null,91,null,null,null,null,null,97,null,null,null,91,null,95,null,null,null,null,null,null,null,97,null,null,null,null,101,null,94,null,null,null,null,null,null,92,null,null,null,96,null,null,94,null,null,96,null,null,93,null,null,null,null,null,null,null,97]";
		TreeNode one = TreeNode.str2tree(s);
    	FindDuplicateSubtrees2 findDuplicateSubtrees = new FindDuplicateSubtrees2();
		List<TreeNode> result = findDuplicateSubtrees.findDuplicateSubtrees(one);
		for (TreeNode treeNode : result) {
			System.out.println(treeNode);
		}
	}
}
