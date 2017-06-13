package leetcode582;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is
 just like a tree structure. Only one process has PPID that is 0, which means this process 
 has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains 
PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of 
PIDs of processes that will be killed in the end. You should assume that when a process is 
killed, all its children processes will be killed. No order is required for the final answer.

Example 1:

Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.

Note:

    The given kill id is guaranteed to be one of the given PIDs.
    n >= 1.

 * @author liyuncong
 *
 */
public class KillProcess {
	/**
	 * 思路：构建一棵树，遍历以kill为根的子树，找到需要删除的元素
	 * @param pid
	 * @param ppid
	 * @param kill
	 * @return
	 */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new LinkedList<>();
        if (pid == null || pid.isEmpty()) {
			return result;
		}
        Map<Integer, TreeNode> tree = buildTree(pid, ppid);
        TreeNode killNode = tree.get(kill);
        if (killNode == null) {
			return result;
		}
        List<TreeNode> killNodes = traverse(killNode);
        for (TreeNode treeNode : killNodes) {
			result.add(treeNode.getData());
		}
        return result;
    }
    
    public Map<Integer, TreeNode> buildTree(List<Integer> pid, List<Integer> ppid) {
		Map<Integer, TreeNode> result = new HashMap<>();
		result.put(0, new TreeNode(0));
		for(int i = 0; i < pid.size(); i++) {
			// 先不把treeNode放到父treeNode里去，因为这时父treeNode可能还没有创建
			TreeNode treeNode = new TreeNode(pid.get(i));
			result.put(treeNode.getData(), treeNode);
		}
		for(int i = 0; i < pid.size(); i++) {
			TreeNode parentNode = result.get(ppid.get(i));
			parentNode.addChild(result.get(pid.get(i)));
		}
		return result;
	}
    
    public List<TreeNode> traverse(TreeNode root) {
		List<TreeNode> result = new LinkedList<>();
		result.add(root);
		for(TreeNode treeNode : root.getChildren()) {
			result.addAll(traverse(treeNode));
		}
		return result;
	}
    
    private static class TreeNode {
    	private Integer data;
    	private Integer parent = 0;
    	private List<TreeNode> children = new LinkedList<>();
		public TreeNode(Integer data) {
			super();
			this.data = data;
		}
		public Integer getParent() {
			return parent;
		}
		public void setParent(Integer parent) {
			this.parent = parent;
		}
		public Integer getData() {
			return data;
		}
    	public void addChild(TreeNode child) {
			children.add(child);
		}
		public List<TreeNode> getChildren() {
			return children;
		}
		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", parent=" + parent + ", children=" + children + "]";
		}
    }
    
    public static void main(String[] args) {
    	Integer[] pid = new Integer[]{1, 3, 10, 5};
    	Integer[] ppid = new Integer[] {3, 0, 5, 3};
    	int kill = 5;
    	KillProcess killProcess = new KillProcess();
    	List<Integer> result = killProcess.killProcess(Arrays.asList(pid), Arrays.asList(ppid), kill);
    	for (Integer integer : result) {
			System.out.println(integer);
		}
	}
}
