package leetcode414;

import java.util.TreeSet;

/**
 * 
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 * @author liyuncong
 *
 */
public class ThirdMaximumNumber2 {
	   public int thirdMax(int[] nums) {
	        if (nums.length == 1) 
	        	return nums[0];
	        if (nums.length == 2) 
	        	return (int)Math.max(nums[0],nums[1]);
	        long first = Long.MIN_VALUE;
	        long second = Long.MIN_VALUE;
	        long third = Long.MIN_VALUE;
	        for (int num: nums) {
	            if (num >= first) {
	                if (num == first) 
	                	continue;
	                third = second;
	                second = first;
	                first = num;
	            } else if (num >= second) {
	                if (num == second) 
	                	continue;
	                third = second;
	                second = num;
	            }
	            else if (num >= third) {
	                if (num == third ) 
	                	continue;
	                third = num;
	            }
	        }
	        if (third == Long.MIN_VALUE) 
	        	return (int)first;
	        else 
	        	return (int)third;
	    }
}
