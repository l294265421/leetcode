package leetcode198;

/**
 * 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. 
 * @author yuncong
 *
 */
public class LeetCode198 {
	/**
	 * 动态规划：rob(i) = Math.max(rob(i - 1), rob(i - 2) + nums[i])
	 * @param nums
	 * @return
	 */
    public int rob(int[] nums) {
        if (nums == null) {
			return 0;
		}
        int len = nums.length;
        if (len == 0) {
			return 0;
		}
        if (len == 1) {
			return nums[0];
		}
        if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}
        int[] helper = new int[len + 1];
        helper[0] = 0;
        helper[1] = nums[0];
        for (int i = 2; i < helper.length; i++) {
			helper[i] = Math.max(helper[i - 1], helper[i - 2] + nums[i - 1]);
		}
        return helper[helper.length - 1];
        
    }
    
    public static void main(String[] args) {
		LeetCode198 leetCode198 = new LeetCode198();
		int[] nums = new int[]{0,0,0};
		System.out.println(leetCode198.rob(nums));
	}
}
