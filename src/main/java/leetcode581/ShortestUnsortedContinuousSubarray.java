package leetcode581;

import java.util.Arrays;

/**
 * 
Given an integer array, you need to find one continuous subarray that if you only sort this 
subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array 
sorted in ascending order.

Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

 * @author liyuncong
 *
 */
public class ShortestUnsortedContinuousSubarray {
	/**
	 * 对数组排序，对比元素数组，最后一个不同的元素的索引 - 第一不同的元素的索引 + 1
	 * @param nums
	 * @return
	 */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
			return 0;
		}

        int[] clone = nums.clone();
        Arrays.sort(clone);
        int firstDifferentIndex = -1;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] != clone[i]) {
				firstDifferentIndex = i;
				break;
			}
        }
        if (firstDifferentIndex == -1) {
			return 0;
		}
        int lastDifferentIndex = nums.length;
        for(int j = nums.length - 1; j >= 0; j--) {
        	if (nums[j] != clone[j]) {
				lastDifferentIndex = j;
				break;
			}
        }
        return lastDifferentIndex - firstDifferentIndex + 1;
    }
    
    public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();
		int[] nums = new int[] {2, 6, 4, 8, 10, 9, 15};
		System.out.println(shortestUnsortedContinuousSubarray.findUnsortedSubarray(nums));
	}
}
