package leetcode437;

import java.util.ArrayList;
import java.util.List;

import global.TreeNode;

/**
 * 
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards 
(traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 
1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

 * @author liyuncong
 *
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new ArrayList<>());
    }
    
    public int pathSum(TreeNode root, int sum, List<Integer> ancestors) {
        int result = 0;
        if (root == null) {
			return result;
		}
        if (root.val == sum) {
			result++;
		}
        int thisSum = root.val;
        for(int i = ancestors.size() - 1; i >= 0; i--) {
        	thisSum += ancestors.get(i);
        	if (thisSum == sum) {
				result++;
			}
        }
        ancestors.add(root.val);
        result += pathSum(root.left, sum, ancestors);
        result += pathSum(root.right, sum, ancestors);
        ancestors.remove(ancestors.size() - 1);
        return result;
    }
    
    public static void main(String[] args) {
		PathSumIII pathSumIII = new PathSumIII();
		TreeNode treeNode = TreeNode.str2tree("[10,5,-3,3,2,null,11,3,-2,null,1]");
		System.out.println(pathSumIII.pathSum(treeNode, 8));
	}
}
