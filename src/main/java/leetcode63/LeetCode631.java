package leetcode63;

/**
 * 
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

同leetcode621,使用动态规划的方法;
1. 所处位置为障碍的话，不能到达目的地
 * @author yuncong
 *
 */
public class LeetCode631 {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	if (m == 0) {
			return 0;
		}
    	int n = obstacleGrid[0].length;
    	if (n == 0) {
			return 0;
		}
    	int[][] dp = new int[m + 1][n + 1];
    	for(int i = 0; i < m; i++) {
    		if (obstacleGrid[i][0] == 1) {
				break;
			}
    		dp[i][0] = 1;
    	}
    	for(int j = 0; j < n; j++){
    		if (obstacleGrid[0][j] == 1) {
				break;
			}
    		dp[0][j] = 1;
    	}
    	for(int i = 1; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			if (obstacleGrid[i][j] != 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
    		}
    	}
    	return dp[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
		LeetCode631 leetCode63 = new LeetCode631();
		int[][] obstacleGrid = new int[3][3];
		int rowNum = 0;
		for(int[] row : obstacleGrid) {
			int column = 0;
			for(int num : row) {
				obstacleGrid[rowNum][column] = 0;
				column++;
			}
			rowNum++;
		}
		obstacleGrid[1][1] = 1;
		System.out.println(leetCode63.uniquePathsWithObstacles(obstacleGrid));
	}
}
