package leetcode144;

import global.TreeNode;

import java.util.LinkedList;
import java.util.List;
/**
 * 先根遍历树的规则是这样的：对于遇到的每一个节点，先访问节点本身，然后是左子树根节点，然后是右子树根节点，
 * 最后是右边的兄弟节点。
 * @author liyuncong
 *
 */
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<Integer>();
    	if (root == null) {
			return result;
		}
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
			TreeNode top = stack.pop();
			if (top != null) {
				result.add(top.val);
				stack.push(top.right);
				stack.push(top.left);
			}
		}
        return result;
    }
}
