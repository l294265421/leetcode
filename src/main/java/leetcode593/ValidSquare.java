package leetcode593;

/**
 * 
Given the coordinates of four points in 2D space, return whether the four points 
could construct a square.

The coordinate (x,y) of a point is represented by an integer array with 
two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True

Note:

    All the input integers are in the range [-10000, 10000].
    A valid square has four equal sides with positive length and four equal angles (90-degree angles).
    Input points have no order.

 * @author liyuncong
 *
 */
public class ValidSquare {
	/**
	 * 1.确定四个点的位置，正着摆放的正方形和歪着摆放的正方形
	 * 2.四条边一样长
	 * 3.每条边和邻边垂直（对角线相等）
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return
	 */
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
		return validSquare1(p1, p2, p3, p4) || validSquare2(p1, p2, p3, p4);
	}
	
	public boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] left = left(p1, p2, p3, p4);
		int[] right = right(p1, p2, p3, p4);
		if (left[0] >= right[0]) {
			return false;
		}
		int[][] others = others(left, right, p1, p2, p3, p4);
		int[] upper;
		int[] lower;
		if (others[0][1] > others[1][1]) {
			upper = others[0];
			lower = others[1];
		} else {
			upper = others[1];
			lower = others[0];
		}
		
		if (!(upper[1] > Math.max(left[1], right[1]))) {
			return false;
		}
		if (!(lower[1] < Math.min(left[1], right[1]))) {
			return false;
		}
		if (!(left[0] < Math.min(upper[0], lower[0]))) {
			return false;
		}
		if (!(right[0] > Math.max(upper[0], lower[0]))) {
			return false;
		}
		return validSquareBySortPoint(left, lower, right, upper);
	}
	
	private int[] left(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] result = p1;
		if (p2[0] < result[0]) {
			result = p2;
		}
		if (p3[0] < result[0]) {
			result = p3;
		}
		if (p4[0] < result[0]) {
			result = p4;
		}
		return result;
	}
	
	private int[] right(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] result = p1;
		if (p2[0] > result[0]) {
			result = p2;
		}
		if (p3[0] > result[0]) {
			result = p3;
		}
		if (p4[0] > result[0]) {
			result = p4;
		}
		return result;
	}
	
	
	/**
	 * 正着摆放的正方形
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return
	 */
    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
    	int[] lowerLeft = lowerLeft(p1, p2, p3, p4);
    	int[] upperRight = upperRight(p1, p2, p3, p4);
    	if (!firstLessThanSecond(lowerLeft, upperRight)) {
			return false;
		}
    	
    	int[][] others = others(lowerLeft, upperRight, p1, p2, p3, p4);
    	int[] upperLeft = null;
    	int[] lowerRight = null;
    	if (others[0][0] == lowerLeft[0] && others[0][1] == upperRight[1]) {
			upperLeft = others[0];
		} else if (others[1][0] == lowerLeft[0] && others[1][1] == upperRight[1]) {
			upperLeft = others[1];
		}
    	if (others[0][1] == lowerLeft[1] && others[0][0] == upperRight[0]) {
			lowerRight = others[0];
		} else if (others[1][1] == lowerLeft[1] && others[1][0] == upperRight[0]) {
			lowerRight = others[1];
		}
    	if (upperLeft == null || lowerRight == null || upperLeft == lowerRight) {
			return false;
		}
    	return validSquareBySortPoint(lowerLeft, lowerRight, upperRight, upperLeft);
    }
    
    public boolean validSquareBySortPoint(int[] first, int[] second, int[] third, int[] fourth) {
    	Line line1 = new Line(first, second);
    	Line line2 = new Line(second, third);
    	Line line3 = new Line(third, fourth);
    	Line line4 = new Line(fourth, first);
    	if (!(line1.lengthEqual(line2) && line1.lengthEqual(line3) && line1.lengthEqual(line4))) {
			return false;
		}
    	Line diagonal1 = new Line(first, third);
    	Line diagonal2 = new Line(second, fourth);
    	return diagonal1.vertical(diagonal2);
    }
    
    private int[][] others(int[] first, int[] second, int[] p1, int[] p2, int[] p3, int[] p4) {
    	int[][] others = new int[2][2];
    	int index = 0;
    	if (firstNeSecondThird(p1, first, second)) {
			others[index] = p1;
			index++;
		}
    	if (firstNeSecondThird(p2, first, second)) {
			others[index] = p2;
			index++;
		}
    	if (firstNeSecondThird(p3, first, second)) {
			others[index] = p3;
			index++;
		}
    	if (firstNeSecondThird(p4, first, second)) {
			others[index] = p4;
		}
    	return others;
	}
    
    private boolean firstNeSecondThird(int[] first, int[] second, int[] third) {
		return first != second && first != third;
	}
    
    private int[] lowerLeft(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] result = p1;
		if (firstLeSecond(p2, result)) {
			result = p2;
		}
		if (firstLeSecond(p3, result)) {
			result = p3;
		}
		if (firstLeSecond(p4, result)) {
			result = p4;
		}
		return result;
	}
    
    /**
     * 小于等于
     * @param first
     * @param second
     * @return
     */
    private boolean firstLeSecond(int[] first, int[] second) {
		return first[0] <= second[0] && first[1] <= second[1];
	}
    
    private boolean firstGeSecond(int[] first, int[] second) {
		return first[0] >= second[0] && first[1] >= second[1];
	}
    
    /**
     * 小于
     * @param first
     * @param second
     * @return
     */
    private boolean firstLessThanSecond(int[] first, int[] second) {
		return first[0] < second[0] && first[1] < second[1];
	}
    
    private int[] upperRight(int[] p1, int[] p2, int[] p3, int[] p4){
    	int[] result = p1;
    	if (firstGeSecond(p2, result)) {
			result = p2;
		}
    	if (firstGeSecond(p3, result)) {
			result = p3;
		}
    	if (firstGeSecond(p4, result)) {
			result = p4;
		}
    	return result;
    }
    
    private class Line {
    	private int[] point1;
    	private int[] point2;
    	private int[] vector = new int[2];
    	/**
    	 * vector中元素的平方和
    	 */
    	private double length;
		public Line(int[] point1, int[] point2) {
			super();
			this.point1 = point1;
			this.point2 = point2;
			this.vector[0] = point1[0] - point2[0];
			this.vector[1] = point1[1] - point2[1];
			this.length = Math.pow(vector[0], 2) + Math.pow(vector[1], 2);
		}
		
		public boolean lengthEqual(Line other) {
			return this.length == other.length;
		}
    	
		public boolean vertical(Line other) {
			int[] vectorOther = other.vector;
			double dotProduct = vector[0] * vectorOther[0] + vector[1] * vectorOther[1];
			return dotProduct == 0;
		}
    }
    
    public static void main(String[] args) {
		ValidSquare validSquare = new ValidSquare();
		int[] p1 = new int[]{0,0}, p2 = new int[]{0,0}, p3 = new int[]{0,0}, p4 = new int[]{0,0};
		System.out.println(validSquare.validSquare(p1, p2, p3, p4));
	}
}
