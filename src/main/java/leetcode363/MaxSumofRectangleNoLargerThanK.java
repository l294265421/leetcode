package leetcode363;

/**
 * 
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2

The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

Note:

    The rectangle inside the matrix must have an area > 0.
    What if the number of rows is much larger than the number of columns?

 * @author liyuncong
 *
 */
public class MaxSumofRectangleNoLargerThanK {
	/**
	 * 从只包含一个元素的矩阵到包含所有元素的矩阵，依次遍历
	 * @param matrix
	 * @param k
	 * @return
	 */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int candidate = Integer.MIN_VALUE;
        for(int rowNum = 1; rowNum <= rows; rowNum++) {
        	for(int columnNum = 1; columnNum <= columns; columnNum++) {
        		// 对滑动窗口内的值求和
        		for(int startRow = 0; startRow + rowNum <= rows; startRow++) {
        			for(int startColumn = 0; startColumn + columnNum <= columns; startColumn++) {
        				int temp = subMatrixSum(matrix, startRow, startColumn, rowNum, columnNum);
        				if (temp == k) {
							return k;
						}
        				if (temp < k && temp > candidate) {
							candidate = temp;
						}
        			}
        		}
        	}
        }
        return candidate;
    }
    
    private int subMatrixSum(int[][] matrix, int startRow, int startColumn, int rowNum, int columnNum) {
		int sum = 0;
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < columnNum; j++) {
				sum += matrix[startRow + i][startColumn + j];
			}
		}
		return sum;
	}
    
    public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,  0, 1}, {0, -2, 3}};
		MaxSumofRectangleNoLargerThanK maxSumofRectangleNoLargerThanK = new MaxSumofRectangleNoLargerThanK();
		System.out.println(maxSumofRectangleNoLargerThanK.maxSumSubmatrix(matrix, 2));
	}
}
