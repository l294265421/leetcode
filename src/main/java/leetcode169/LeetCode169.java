package leetcode169;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历数组，统计每个数出现的次数，遇到满足条件的元素就直接返回。
 * @author liyuncong
 *
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numTimesPair = new 
        		HashMap<Integer, Integer>();
        int len = nums.length;
        if (len == 1) {
			return nums[0];
		}
        int limit = len / 2;
        for (int i : nums) {
			if (numTimesPair.containsKey(i)) {
				int newTimes = numTimesPair.get(i) + 1;
				if (newTimes > limit) {
					return i;
				}
				numTimesPair.put(i, newTimes);
			} else {
				// 出现一次不可能是主要元素
				numTimesPair.put(i, 1);
			}
		}
        return -1;
    }
}
