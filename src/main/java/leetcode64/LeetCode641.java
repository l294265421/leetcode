package leetcode64;

/**
 * 
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * @author liyuncong
 *
 */
public class LeetCode641 {
	/**
	 * minPathSum(i,j) = grid[i][j] + min(minPathSum(i - 1, j), minPathSum(i, j - 1))
	 * @param grid
	 * @return
	 */
    public int minPathSum(int[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
    	int m = grid.length;
    	int n = grid[0].length;
    	for(int i = 1; i < m; i++) {
    		grid[i][0] += grid[i - 1][0];
    	}
    	for(int j = 1; j < n; j++) {
    		grid[0][j] += grid[0][j - 1];
    	}
    	for(int i = 1; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    		}
    	}
    	return grid[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
		LeetCode641 leetCode641 = new LeetCode641();
		int[][] grid = new int[][]{{1, 2}, {1, 1}};
		System.out.println(leetCode641.minPathSum(grid));
	}
}
