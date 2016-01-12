package leetcode235;

import global.TreeNode;

/**
 * p,q要么相等，要么不等； 如果相等，结果就是它们自己；
 * 如果不等，对p,q进行搜索，走到某个节点，表示p,q都是这个节点的后代，如果其中一个和这个节点相等，
 * 那么这个节点就是结果，如果它们一个大于这个节点一个小于这个节点，这个节点也是结果，否则就继续往 下搜索。
 * 
 * @author yuncong
 *
 */
public class LeetCode235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == q) {
			return p;
		} else {
			if (p == root || q == root || 
					(p.val > root.val && q.val < root.val) ||
					(p.val < root.val && q.val > root.val)) {
				return root;
			} else {
				if (p.val < root.val) {
					return lowestCommonAncestor(root.left, p, q);
				} else {
					return lowestCommonAncestor(root.right, p, q);
				}
			}
		}
	}
}
