package leetcode152;

/**
 * 动态规划：
 * 1.
 * （1.状态）以nums[i]结尾的最大积子数组的积imax(2.状态转移方程)等于
 * max(nums[i], nums[i] * i-1max, nums[i] * imin)；
 * 2.
 * （1.状态）以nums[i]结尾的最小积子数组的积imin(2.状态转移方程)等于
 * min(nums[i], nums[i] * i-1max, nums[i] * imin)；
 * 
 * 寻找以nums[i]结尾的最大积子数组的积和最小积子数组的积的过程可以这样理解：
 * （1）最大积要么就是nums[i],要么是nums[i]与前面一些数的积的乘积，前面
 * 一些数的积介于i-1min<x<i-1max之间，于是问题抽象成了下面的数学问题：
 * 方程nums[i] * x = y, 定义域（i-1min<x<i-1max， x = 1），求方程的
 * 最大值和最小值
 * @author liyuncong
 *
 */
public class LeetCode1521 {
    public int maxProduct(int[] nums) {
    	int len = nums.length;
    	int[] maxs = new int[len];
    	maxs[0] = nums[0];
    	int[] mins = new int[len];
    	mins[0] = nums[0];
    	int max = nums[0];
    	for (int i = 1; i < len; i++) {
			maxs[i] = max(nums[i], nums[i] * maxs[i - 1], nums[i] * mins[i - 1]);
			if (maxs[i] > max) {
				max = maxs[i];
			}
			mins[i] = min(nums[i], nums[i] * maxs[i - 1], nums[i] * mins[i - 1]);
		}
    	return max;
    }
    
	public int max(int num1, int num2, int num3) {
		return num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2
				: num3);
	}
	
	public int min(int num1, int num2, int num3) {
		return num1 < num2 ? (num1 < num3 ? num1 : num3) : (num2 < num3 ? num2
				: num3);
	}
	
	public static void main(String[] args) {
		LeetCode1521 leetCode1521 = new LeetCode1521();
		int[] nums = new int[] {-4, -3, -2};
		System.out.println(leetCode1521.maxProduct(nums));
	}
}
