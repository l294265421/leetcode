package leetcode303;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Given an integer array nums, find the sum of the elements between indices i and j 
(i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.

 * @author liyuncong
 *
 */
public class NumArray {
	private Map<String, Integer> cache = new HashMap<>();
	private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
    	String index = i + "+" + j;
        Integer sum = cache.get(index);
        if (sum != null) {
			return sum;
		} else {
			sum = 0;
		}
        for(; i <= j; i++) {
        	sum += nums[i];
        }
        cache.put(index, sum);
        return sum;
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
