package leetcode137;

import java.util.HashMap;
import java.util.Map;

public class LeetCode137 {
    public int singleNumber(int[] nums) {
    	/**
    	 * 统计每一个数字出现的次数，然后找到那个出现次数不是３的数，返回即可
    	 */
        Map<Integer, Integer> numTimePair = new HashMap<>();
        for (int i : nums) {
			if (numTimePair.containsKey(i)) {
				numTimePair.put(i, numTimePair.get(i) + 1);
			} else {
				numTimePair.put(i, 1);
			}
		}
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : numTimePair.entrySet()) {
        	if (entry.getValue() != 3) {
				result = entry.getKey();
			}
        }
        return result;
    }
}
