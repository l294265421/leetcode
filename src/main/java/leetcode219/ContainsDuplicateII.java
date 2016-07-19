package leetcode219;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers and an integer k, find out whether there are two distinct 
 * indices i and j in the array such that nums[i] = nums[j] and the difference between i 
 * and j is at most k. 
 * @author liyuncong
 *
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return strategy3(nums, k);
    }
    
    /**
     * 每一个元素，跟两边位置相差k之内的元素比较，有重复计算，两个元素相互之间比较了两次；
     * Time Limit Exceeded
     * @param nums
     * @param k
     * @return
     */
    private boolean strategy1(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			int numi = nums[i];
			int low = i - k > 0? i - k : 0;
			int up = i + k < len - 1?i + k : len - 1;
			for(int j = low; j <= up; j++) {
				if (j != i && nums[j] == numi) {
					return true;
				}
			}
		}
		return false;
	}
    
    /**
     * 从左向右，对每个元素，比较右边k个位置内的元素
     * @param nums
     * @param k
     * @return
     */
    private boolean strategy2(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		int len = nums.length;
		for(int i = 0; i < len; i ++) {
			int up = i + k < len - 1 ? i + k : len - 1;
			for(int j = i + 1; j <= up; j ++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
    
    private boolean strategy3(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		Map<Integer, Integer> helper = new HashMap<Integer, Integer>();
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			if (helper.containsKey(nums[i]) && i - helper.get(nums[i]) <= k) {
				return true;
			}
			helper.put(nums[i], i);
		}
		return false;
	}
}
