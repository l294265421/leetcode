package leetcode207;

import java.util.ArrayList;
import java.util.List;

public class LeetCode207 {
	static final int UNVISITED = 0;
	static final int NOW_VISITING = 1;
	static final int VISITED = 2;

	public boolean canFinish(int n, int[][] ps) {
		// 把图的边表表示转化为邻接表表示
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();

		for (int[] e : ps)
			graph[e[0]].add(e[1]);

		// 节点状态
		int[] stat = new int[n];

		for (int node = 0; node < stat.length; node++) {
			if (stat[node] == UNVISITED && hasCycle(graph, stat, node))
				return false;
		}

		return true;
	}

	/**
	 * 思路：深度优先访问图，如果一个节点还没被访问结束，而且从该节点的后继元素出发又回到了
	 * 这个节点，就说明图中有环。
	 * @param graph
	 * @param stat
	 * @param node
	 * @return
	 */
	private boolean hasCycle(List<Integer>[] graph, int[] stat, int node) {
		if (stat[node] == VISITED)
			return false;
		if (stat[node] == NOW_VISITING)
			return true; // has cycle

		/* visiting */
		stat[node] = NOW_VISITING;

		for (int sub : graph[node]) {
			if (hasCycle(graph, stat, sub)) {
				stat[node] = VISITED;
				return true;
			}

		}

		// visited
		stat[node] = VISITED;
		return false;
	}
}
