package leetcode167;

/**
 * 
Given an array of integers that is already sorted in ascending order, find two numbers 
such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to 
the target, where index1 must be less than index2. Please note that your returned 
answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use 
the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
 * @author liyuncong
 *
 */
public class TwoSumII2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length;
        while (left < right) {
            int t = target - numbers[left];
            // Find the largest element that is equal to or less than t
            right = binarySearch(numbers, false, t, left + 1, right - 1);
            if (numbers[right] == t)
                break;
            t = target - numbers[right];
            // Find the smallest element that is equal to or larger than t
            left = binarySearch(numbers, true, t, left + 1, right - 1);
            if (numbers[left] == t)
                break;
        }
        return new int[] {left + 1, right + 1};
    }
    
    private int binarySearch(int[] nums, boolean large, int target, int start, int end) {
        if (start == end)
            return start;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        int mid = (start + end) / 2;
        return large ? mid + 1 : mid;
    }
    
    public static void main(String[] args) {
		TwoSumII2 twoSumII = new TwoSumII2();
		int[] numbers = new int[] {2, 7, 11, 15};
		int[] result = twoSumII.twoSum(numbers, 9);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
