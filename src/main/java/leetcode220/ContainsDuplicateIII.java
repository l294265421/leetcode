package leetcode220;

import java.util.TreeSet;

/**
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j 
 * is at most k. 
 * @author liyuncong
 *
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return strategy2(nums, k, t);
    }
    
    /**
     * Time Limit Exceeded
     * @param nums
     * @param k
     * @param t
     * @return
     */
    private boolean strategy1(int[] nums, int k, int t) {
		if (nums == null) {
			return false;
		}
		
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			int up = i + k < len - 1 ? i + k : len -1;
			long numsi = nums[i];
			for(int j = i + 1; j <= up; j++) {
				long numsj = nums[j];
				if (Math.abs(numsi - numsj) <= t) {
					return true;
				}
			}
		}
		return false;
	}
    
    /**
     * This problem requires to maintain a window of size k of the previous values that can be 
     * queried for value ranges. The best data structure to do that is Binary Search Tree. 
     * As a result maintaining the tree of size k will result in time complexity O(N lg K). 
     * In order to check if there exists any value of range abs(nums[i] - nums[j]) two simple queries 
     * can be executed both of time complexity O(lg K)
     * 
     * Here is the whole solution using TreeMap.
     * @param nums
     * @param k
     * @param t
     * @return
     */
    private boolean strategy2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        // 过去k个值的窗口，TreeSet使得查询速度变为log(n)
        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
            	// 一次可能删除多个元素，这会导致问题
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
	
    public static void main(String[] args) {
		TreeSet<Integer> integers = new TreeSet<>();
		integers.add(1);
		integers.add(1);
		integers.remove(1);
		System.out.println(integers.size());
	}
}
