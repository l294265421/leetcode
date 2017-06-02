package leetcode598;

/**
 * 
Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array
 with two positive integers a and b, which means M[i][j] should be added by one for all 
 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after 
performing all the operations.

Example 1:

Input: 
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation: 
Initially, M = 
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M = 
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M = 
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.

Note:

    The range of m and n is [1,40000].
    The range of a is [1,m], and the range of b is [1,n].
    The range of operations size won't exceed 10,000.

Subscribe to see which companies asked this question.

 * @author liyuncong
 *
 */
public class RangeAdditionII {
	/**
	 * 理解：
	 * (1)M[0][0]是在每一次操作中都会加1的,也就是说M[0][0]一定是最大值
	 * (2)所有操作的交集大小，就是最终结果
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
			return m * n;
		}
        if (ops.length == 1) {
			return ops[0][0] * ops[0][1];
		}
        int[] commonOperations = ops[0];
        for(int i = 1; i < ops.length; i++) {
        	commonOperations = commonOperation(commonOperations, ops[i]);
        }
        return commonOperations[0] * commonOperations[1];
    }
    
    private int[] commonOperation(int[] operation1, int[] operation2) {
		int[] result = new int[2];
		result[0] = Math.min(operation1[0], operation2[0]);
		result[1] = Math.min(operation1[1], operation2[1]);
		return result;
	}
    
    public static void main(String[] args) {
		int[][] ops = new int[2][2];
		int[] op0 = new int[] {2, 2};
		int[] op1 = new int[] {3, 3};
		ops[0] = op0;
		ops[1] = op1;
		RangeAdditionII rangeAdditionII = new RangeAdditionII();
		System.out.println(rangeAdditionII.maxCount(3, 3, ops));
	}
}
