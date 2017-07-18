package leetcode62;

/**
 * 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to 
reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there? 

Note: m and n will be at most 100.

 * @author yuncong
 *
 */
public class LeetCode62 {
	private int pathNum;
	// 终点横坐标
	private int mMinusOne;
	// 终点纵坐标
	private int nMinusOne;
    public int uniquePaths(int m, int n) {
    	this.mMinusOne = m - 1;
    	this.nMinusOne = n - 1;
    	findPathNum(0, 0);
        return this.pathNum;
    }
    
    /**
     * 树的先序遍历，根的坐标决定了它是否有左子树或右子树
     * @param m
     * @param n
     */
    public void findPathNum(int m, int n) {
		if (m == this.mMinusOne && n == this.nMinusOne) {
			this.pathNum++;
		}
		if(m < this.mMinusOne) {
			findPathNum(m + 1, n);
		}
		
		if (n < this.nMinusOne) {
			findPathNum(m, n + 1);
		}
	}
    
    public static void main(String[] args) {
		LeetCode62 leetCode62 = new LeetCode62();
		System.out.println(leetCode62.uniquePaths(2, 4));
	}
}
