package leetcode152;

/**
 *  Time Limit Exceeded
 * @author liyuncong
 *
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        // 候选最大乘积子数组必定以第i个元素开头
        for(int i = 0; i < len; i++) {
        	int calculated = nums[i];
        	if (calculated > result) {
				result = calculated;
			}
        	for(int j = i + 1; j < len; j++) {
        		// 复用之前的计算结果
        		calculated *= nums[j];
        		if (calculated > result) {
    				result = calculated;
    			}
        	}
        }
        return result;
    }
}
