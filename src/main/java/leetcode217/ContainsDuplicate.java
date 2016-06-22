package leetcode217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 
 * @author liyuncong
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        return strategy1(nums);
    }
    
    private boolean strategy1(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
    
    /**
     *  Time Limit Exceeded
     * @param nums
     * @return
     */
    private boolean strategy2(int[] nums) {
		Set<Integer> helper = new HashSet<>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int temp = nums[i];
			if (helper.contains(temp)) {
				return true;
			}
			helper.add(temp);
		}
		return false;
	}
}
