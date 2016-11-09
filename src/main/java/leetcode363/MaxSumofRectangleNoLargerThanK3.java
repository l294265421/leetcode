package leetcode363;

import java.util.TreeSet;

/**
 * 
 Given a non-empty 2D matrix matrix and an integer k, find the max sum of a
 * rectangle in the matrix such that its sum is no larger than k.
 * 
 * Example:
 * 
 * Given matrix = [ [1, 0, 1], [0, -2, 3] ] k = 2
 * 
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is
 * the max number no larger than k (k = 2).
 * 
 * Note:
 * 
 * The rectangle inside the matrix must have an area > 0. What if the number of
 * rows is much larger than the number of columns?
 * 
 * @author liyuncong
 * 
 */
public class MaxSumofRectangleNoLargerThanK3 {
	/*
	 * first consider the situation matrix is 1D we can save every sum of
	 * 0~i(0<=i<len) and binary search previous sum to find possible result for
	 * every index, time complexity is O(NlogN). so in 2D matrix, we can sum up
	 * all values from row i to row j and create a 1D array to use 1D array
	 * solution. If col number is less than row number, we can sum up all values
	 * from col i to col j then use 1D array solution.
	 * 
	 * 如果要计算i列到j列块的和，可以用前j列的和减去前i列的和。
	 */
	public int maxSumSubmatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		int m = Math.min(row, col);
		int n = Math.max(row, col);
		// indicating sum up in every row or every column
		boolean colIsBig = col > row;
		int res = Integer.MIN_VALUE;
		// 结束的行/列
		for (int i = 0; i < m; i++) {
			// 记录每一行/列的值
			int[] array = new int[n];
			// sum from row j to row i
			// 起始的行/列
			for (int j = i; j >= 0; j--) {
				// 前k行/列的和
				int val = 0;
				// 存储前k列/行的和，前k行/列的和减去前h行/列的和等于从h+1行/列到k行/列的和
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(0);
				// traverse every column/row and sum up
				for (int k = 0; k < n; k++) {
					array[k] = array[k]
							+ (colIsBig ? matrix[j][k] : matrix[k][j]);
					val = val + array[k];
					// use TreeMap to binary search previous sum to get possible
					// result
					// subres越接近val - target，val - subres(某一个区域的和)就越接近target
					// subres大于等于var - target,val - subres就小于等于target
					Integer subres = set.ceiling(val - target);
					if (null != subres) {
						res = Math.max(res, val - subres);
					}
					set.add(val);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 0, 1 }, { 0, -2, 3 } };
		MaxSumofRectangleNoLargerThanK3 maxSumofRectangleNoLargerThanK = new MaxSumofRectangleNoLargerThanK3();
		System.out.println(maxSumofRectangleNoLargerThanK.maxSumSubmatrix(
				matrix, 2));
	}
}
