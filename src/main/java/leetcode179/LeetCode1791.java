package leetcode179;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 * @author liyuncong
 *
 */
public class LeetCode1791 {
	private String largestNumber = "0";
	/**
	 * 1.高位越大，结果越大
	 * 2.选高位最大的
	 * 3.如果高位一样大，不同的数，分裂成不同情况，最后选其中最大的
	 * @param nums
	 * @return
	 */
    public String largestNumber(int[] nums) {
		if (nums == null) {
			return "0";
		}
		shiftAllZeroToRight(nums);
		largestNumber(nums, 0);
        return removeLeadingZero(this.largestNumber);
    }
    
    private void largestNumber(int[] nums, int start) {
		int len = nums.length;
		if (len - 1 == start || nums[start] == 0) {
			StringBuilder candidate = new StringBuilder();
			for (int num : nums) {
				candidate.append(num);
			}
			if (compare(candidate.toString(), this.largestNumber) > 0) {
				this.largestNumber = candidate.toString();
			}
			return;
		}
		String maxHeadDigit = maxHeadDigit(nums, start);
		
		List<Integer> selectedIndex = selectedIndex(nums, start, maxHeadDigit);
		for (Integer index : selectedIndex) {
			int[] copy = nums.clone();
			int temp = copy[start];
			copy[start] = copy[index];
			copy[index] = temp;
			largestNumber(copy, start + 1);
		}
	}
    
    private String maxHeadDigit(int[] nums, int start) {
		// 确定高位最大值
    	String max = "0";
    	int len = nums.length;
    	if (len == 0 || start >= len) {
			return max;
		}
    	
    	for(int i = start; i < len; i++) {
    		String num = String.valueOf(nums[i]).substring(0, 1);
    		if (compare(num, max) > 0) {
				max = num;
			}
    	}
    	return max;
	}
    
    private List<Integer> selectedIndex(int[] nums, int start, String maxHeadDigit) {
    	List<Integer> result = new LinkedList<>();
    	if (nums == null ) {
			return result;
		}
    	int len = nums.length;
    	if (len == 0 || start >= len) {
			return result;
		}
    	
    	// 确定候选元素
    	for(int i = start; i < len; i++) {
    		String num = String.valueOf(nums[i]).substring(0, 1);
    		if (maxHeadDigit.equals(num)) {
				result.add(i);
			}
    	}
    	return result;
	}
    
	/**
	 * number1比number2大，返回正数,小返回负数，相等返回0
	 * @param number1
	 * @param number2
	 * @return
	 */
	public int compare(String number1, String number2) {
		return number1.compareTo(number2);
	}
	
	private String removeLeadingZero(String num) {
		int len = num.length();
		int start = 0;
		for(int i = 0; i < len - 1; i++) {
			if (num.substring(i, i + 1).equals("0")) {
				start++;
			} else {
				break;
			}
		}
		return num.substring(start);
	}

	private void shiftAllZeroToRight(int[] nums) {
		if (nums == null) {
			return;
		}
		int len = nums.length;
		int leftZeroIndex = len;
		for(int i = len - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				leftZeroIndex--;
				int temp = nums[i];
				nums[i] = nums[leftZeroIndex];
				nums[leftZeroIndex] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		LeetCode1791 leetCode1791 = new LeetCode1791();
		int[] nums = new int[] {41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
		System.out.println(leetCode1791.largestNumber(nums));
	}
}
