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
public class NumArray2 {
	private int[] nums;
    public NumArray2(int[] nums) {
    	for(int i = 1; i < nums.length; i++) {
    		nums[i] = nums[i] + nums[i - 1];
    	}
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
    	if (i == 0) {
			return this.nums[j];
		}
    	return this.nums[j] - this.nums[i - 1];
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		NumArray2 numArray = new NumArray2(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println("2017-07-08".compareTo("2017-07-07"));
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
