package leetcode643;

/**
 * 
Given an array consisting of n integers, find the contiguous subarray of given length 
k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

Note:

    1 <= k <= n <= 30,000.
    Elements of the given array will be in the range [-10,000, 10,000].

 * @author liyuncong
 *
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int kNumSum = 0;
        for(int i = 0; i < k; i++) {
        	kNumSum += nums[i];
        }
        int maxKNumSum = kNumSum;
        for(int i = k; i < nums.length; i++) {
        	kNumSum = kNumSum + nums[i] - nums[i - k];
        	if (kNumSum > maxKNumSum) {
				maxKNumSum = kNumSum;
			}
        }
        return maxKNumSum / (double)k;
    }
    public static void main(String[] args) {
		MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
		int[] nums = new int[] {1,12,-5,-6,50,3};
		System.out.println(maximumAverageSubarrayI.findMaxAverage(nums, 4));
	}
}
