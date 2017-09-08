package leetcode447;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple 
of points (i, j, k) such that the distance between i and j equals the distance between
 i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and 
coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

 * @author liyuncong
 *
 */
public class NumberOfBoomerangs2 {
	/**
	 * 候选者个数是从points中任选3个的排列个数
	 * @param points
	 * @return
	 */
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<String, Boolean> compareResult = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
        	for(int j = i + 1; j < points.length; j++) {
        		for(int k = j + 1; k < points.length; k++) {
        			result += numberOfBoomerangs(compareResult, points, i, j , k);
        		}
        	}
        }
        return result;
    }
    
    public int numberOfBoomerangs(Map<String, Boolean> compareResult, int[][] points, int i, int j, int k) {
		Double distanceOneTwo = distance(points, i, j);
		Double distanceOneThree = distance(points, i, k);
		Double distanceTwoThree = distance(points, k, j);
		int result = 0;
		if (Double.compare(distanceOneTwo, distanceOneThree) == 0) {
			result += 2;
		}
		if (Double.compare(distanceTwoThree, distanceOneTwo) == 0) {
			result += 2;
		}
		if (Double.compare(distanceOneThree, distanceTwoThree) == 0) {
			result += 2;
		}
		return result;
	}
    
    private double distance(int[][] points, int i, int j) {
		return Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
	}
    
    public static void main(String[] args) {
		NumberOfBoomerangs2 numberOfBoomerangs = new NumberOfBoomerangs2();
		int[][] points = new int[][] {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs.numberOfBoomerangs(points));
	}
}
