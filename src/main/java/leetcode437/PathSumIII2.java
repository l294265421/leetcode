package leetcode437;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class PathSumIII2 {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        // 值 值出现的次数
        // 值 是当前路径上从根节点到某个节点路径上数字之和
        map.put(0, 1);
        helper(root, sum, 0, map);
        return count;
    }
    
    private void helper(TreeNode node, int sum, int total, Map<Integer, Integer> map){
        if(node == null){
            return;
        }
        // 从根节点到当前节点路径上数字的和
        total += node.val;
        count += map.getOrDefault(total - sum, 0);
        int c = map.getOrDefault(total, 0);
        map.put(total, c + 1);
        helper(node.left, sum, total, map);
        helper(node.right, sum, total, map);
        map.put(total, c);
    }
    
    public static void main(String[] args) {
		PathSumIII2 pathSumIII = new PathSumIII2();
		TreeNode treeNode = TreeNode.str2tree("[10,5,-3,3,2,null,11,3,-2,null,1]");
		System.out.println(pathSumIII.pathSum(treeNode, 8));
	}
}
