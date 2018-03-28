package leetcode766;

/**
 * 
如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。

给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

示例 1:

输入: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
输出: True
解释:
1234
5123
9512

在上面这个矩阵中, 对角线分别是 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", 各条对角线上的所有元素都相同, 因此答案是True。

示例 2:

输入: matrix = [[1,2],[2,2]]
输出: False
解释: 
对角线, 比如: "[1, 2]" 上有不同的元素。

注意:

     matrix (矩阵)是一个包含整数的二维数组。
    matrix 的行数和列数均在 [1, 20]范围内。
    matrix[i][j] 包含的整数在 [0, 99]范围内。


 * @author liyuncong
 *
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        for(int i = rowNum - 2; i >= 0; i--) {
        	for(int j = i, k = 0; j < rowNum - 1 && k < colNum - 1; j++, k++) {
        		if (matrix[j][k] != matrix[j + 1][k + 1]) {
					return false;
				}
        	}
        }
        
        for(int i = 1; i < colNum - 1; i++) {
        	for(int j = 0, k = i; j < rowNum - 1 && k < colNum - 1; j++, k++) {
        		if (matrix[j][k] != matrix[j + 1][k + 1]) {
					return false;
				}
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
		ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
		
		int[][] matrix = new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
		
		matrix = new int[][] {{1,2},{2,2}};
		System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
		
		matrix = new int[] [] {{11,74,0,93},{40,11,74,7}};
		// 11,74,0,93
		// 40,11,74,7
		System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
	}
}
