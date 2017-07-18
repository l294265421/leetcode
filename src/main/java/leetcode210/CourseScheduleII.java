package leetcode210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you 
have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of 
them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have 
finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]

There are a total of 4 courses to take. To take course 3 you should 
have finished both courses 1 and 2. Both courses 1 and 2 should be 
taken after you finished course 0. So one correct course order is 
[0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, 
not adjacency matrices. Read more about how a graph is represented
({@link https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs}). 

{@link leetcode207.CourseSchedule}
 * @author liyuncong
 *
 */
public class CourseScheduleII {
	private static final int UNVISITED = 0;
	private static final int NOW_VISITING = 1;
	private static final int VISITED = 2;
	// 深度优先遍历图，保证了，每个节点（课程）的邻接点（先修课程）
	// 都先被访问
	private List<Integer> visitOrder = new LinkedList<>();
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) {
			return new int[0];
		}
        int[] result = new int[visitOrder.size()];
        int i = 0;
        for(Integer integer : visitOrder) {
        	result[i] = integer;
        	i++;
        }
        return result;
    }
    
	/**
	 * 
	 * @param n 节点数目
	 * @param ps 图的边表表示
	 * @return 是否能修完课程
	 */
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
	 * 判断从邻接表（图的表示）的一个节点出发，是否存在环
	 * 思路：深度优先访问图，如果一个节点还没被访问结束，而且从该节点的后继元素出发又回到了
	 * 这个节点，就说明图中有环。
	 * @param graph 图的邻接表表示
	 * @param stat 图中各节点的状态
	 * @param node 节点
	 * @return 从节点node出发，存在环返回true，否则返回false
	 */
	private boolean hasCycle(List<Integer>[] graph, int[] stat, int node) {
		// node被访问过，意味着node的邻接点也都被访问过了；
		// 当遇到node被访问过，并且访问过程中，并没有回到node,
		// 说明以node为根的子图不存在环。
		if (stat[node] == VISITED)
			return false;
		if (stat[node] == NOW_VISITING)
			return true; // has cycle

		/* visiting */
		stat[node] = NOW_VISITING;

		for (int sub : graph[node]) {
			if (hasCycle(graph, stat, sub)) {
				return true;
			}
		}

		// visited
		stat[node] = VISITED;
		visitOrder.add(node);
		return false;
	}
	
	public static void main(String[] args) {
		CourseScheduleII courseScheduleII = new CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = new int[][] {{1,0},{2,0},{3,1},{3,2}};
		int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
