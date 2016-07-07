package leetcode41;

import java.util.HashSet;
import java.util.Set;

/**
 * 
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
 * @author liyuncong
 *
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        return strategy1(nums);
    }
    
    /**
     * 利用hash表
     * @param nums
     * @return
     */
    private int strategy1(int[] nums) {
		Set<Integer> helper = new HashSet<>();
		for (int num : nums) {
			if (num > 0) {
				helper.add(num);
			}
		}
		int next = 1;
		while (helper.contains(next)) {
			next++;
		}
		return next;
	}
    
    public static void main(String[] args) {
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		int[] nums = new int[]{3,4,-1,1};
		System.out.println(firstMissingPositive.firstMissingPositive(nums));
	}
}
