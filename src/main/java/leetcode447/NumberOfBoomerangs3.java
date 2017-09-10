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
public class NumberOfBoomerangs3 {
	/**
	 * 候选者个数是从points中任选3个的排列个数
	 * @param points
	 * @return
	 */
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        int[][] distances = new int[points.length][points.length];
        for(int i = 0; i < points.length; i++) {
        	for(int j = i + 1; j < points. length; j++) {
        		distances[i][j] = distance(points[i], points[j]);
        	}
        }
        
        for(int i = 0; i < points.length; i++) {
        	for(int j = i + 1; j < points.length; j++) {
        		for(int k = j + 1; k < points.length; k++) {
        			result += numberOfBoomerangs(distances, i, j , k);
        		}
        	}
        }
        return result;
    }
    
    public int numberOfBoomerangs(int[][] distances, int i, int j, int k) {
    	int distanceOneTwo = distances[i][j];
    	int distanceOneThree = distances[i][k];
    	int distanceTwoThree = distances[j][k];
		int result = 0;
		if (distanceOneTwo == distanceOneThree) {
			result += 2;
		}
		if (distanceTwoThree == distanceOneTwo) {
			result += 2;
		}
		if (distanceOneThree == distanceTwoThree) {
			result += 2;
		}
		return result;
	}
    
    private int distance(int[] point1, int[] point2) {
		return ((point2[0] - point1[0]) * (point2[0] - point1[0])) + 
				(point2[1] - point1[1]) *(point2[1] - point1[1]);
	}
    
    public static void main(String[] args) {
		NumberOfBoomerangs3 numberOfBoomerangs = new NumberOfBoomerangs3();
		int[][] points = new int[][] {{-7,-4},{7,5},{3,5},{-4,2},{-1,-9},{-8,-3},{0,9},{-10,-4},{2,6}};
		System.out.println(numberOfBoomerangs.numberOfBoomerangs(points));
	}
}
