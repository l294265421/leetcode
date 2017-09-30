package leetcode463;

/**
 * 
You are given a map in form of a two-dimensional integer grid where 1 represents land 
and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally).
 The grid is completely surrounded by water, and there is exactly one island 
 (i.e., one or more connected land cells). The island doesn't have "lakes" 
 (water inside that isn't connected to the water around the island). One cell is a 
 square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:


 * @author liyuncong
 *
 */
public class IslandPerimeter {
	/**
	 * 扫描所有元素，靠近湖水那边给周长贡献1
	 * @param grid
	 * @return
	 */
    public int islandPerimeter(int[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
    	int result = 0;
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
					if (j == 0 || grid[i][j - 1] == 0) {
						result++;
					}
					if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
						result++;
					}
					if (i == 0 || grid[i - 1][j] == 0) {
						result++;
					}
					if (i == grid.length - 1 || grid[i + 1][j] == 0) {
						result++;
					}
					
				}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		IslandPerimeter islandPerimeter = new IslandPerimeter();
		int[][] grid = new int[][]{{0,1,0,0},
			 {1,1,1,0},
			 {0,1,0,0},
			 {1,1,0,0}};
		System.out.println(islandPerimeter.islandPerimeter(grid));
	}
}
