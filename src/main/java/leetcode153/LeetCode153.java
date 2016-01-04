package leetcode153;

/**
 * 基于这样的结论：如果存在旋转，那么最大的元素和做小的元素是挨着的
 * @author liyuncong
 *
 */
public class LeetCode153 {
    public int findMin(int[] nums) {
        // 寻找第一个i小于i-1的值；没找到，返回nums[0]
    	int len = nums.length;
    	for(int i = 1; i < len; i++) {
    		if (nums[i] < nums[i - 1]) {
				return nums[i];
			}
    	}
    	return nums[0];
    }
}
