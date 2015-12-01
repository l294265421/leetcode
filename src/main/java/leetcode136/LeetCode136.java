package leetcode136;

import java.util.HashSet;
import java.util.Set;

public class LeetCode136 {
    public int singleNumber(int[] nums) {
    	/**
    	 * 第一次遇到某个元素时，把它放进helper里，第二次
    	 * 遇到它时，就从helper里面把它删除，于是最终helper
    	 * 里面只会保存出现一次的那个元素
    	 */
        Set<Integer> helper = new HashSet<Integer>();
        for (int num : nums) {
			boolean isNotContain = helper.add(num);
			if (!isNotContain) {
				helper.remove(num);
			}
		}
        int result = 0;
        for (Integer integer : helper) {
			result = integer;
		}
        return result;
    }
}
