package leetcode179;

import java.util.Arrays;

/**
 * 任意组合，找出最大的；
 * 组合方式，元素的排列；
 */
public class LeetCode179 {
    public String largestNumber(int[] nums) {
    	if (nums == null) {
			return "";
		}
        int[] end = nums.clone();
        String max = intArrayToString(nums);
        nextPermutation(nums);
        while (!Arrays.equals(nums, end)) {
        	if (nums[0] == 0) {
        		nextPermutation(nums);
				continue;
			}
        	String thisNum = intArrayToString(nums);
        	nextPermutation(nums);
			int compareResult = compare(thisNum, max);
			if (compareResult > 0) {
				max = thisNum;
			}
		}
        return max;
    }
    
    /**
	 * 核心思想：从右到左（权重由小到大），找到下一步需要变化的元素的位置
	 * （也就是出现的第一个比后面元素小的元素，这个元素及后面的元素可以变得
	 * 更大，只是降序的话，那就没法变大了，因为已经最大），将它后面的比它大
	 * 的最小元素（这个元素一定存在）和它互换位置，并对后面的元素进行升序排列；
	 * 如果原数组本身就降序排列，就反转使之升序排列
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null) {
			return;
		}
		
		int len = nums.length;
		if (len == 1) {
			return;
		}
		
		// 从后往前，出现的第一个比后面元素小的数的位置
		int firstSmallIndex = len - 2;
		while (firstSmallIndex >= 0) {
			if (nums[firstSmallIndex] < nums[firstSmallIndex + 1]) {
				break;
			} else {
				firstSmallIndex--;
			}
		}
		// 等于-1，说明数组是降序排列的
		if (firstSmallIndex == -1) {
			// 反转数组
			reverse(nums);
		} else {
			// 从firstSmallIndex后面的元素中找到比firstSmallIndex处元素大的最小的数
			int target = -1;
			for(int i = firstSmallIndex + 1; i < len; i++) {
				if (nums[i] > nums[firstSmallIndex]) {
					if (target == -1) {
						target = i;
					} else {
						if (nums[i] < nums[target]) {
							target = i;
						}
					}
				}
			}
			// 交换firstSmallIndex和找到的数的位置上的元素，然后对firstSmallIndex
			// 位置之后的元素升序排列
			int temp = nums[target];
			nums[target] = nums[firstSmallIndex];
			nums[firstSmallIndex] = temp;
			Arrays.sort(nums, firstSmallIndex + 1, len);
		}
	}
	
	public void reverse(int[] nums) {
		int len = nums.length;
		int limit = len / 2;
		for(int i = 0; i < limit; i++) {
			int temp = nums[i];
			nums[i] = nums[len - 1 - i];
			nums[len - 1 - i] = temp;
		}
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
	
	public String intArrayToString(int[] nums) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i : nums) {
			stringBuilder.append(i);
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		LeetCode179 leetCode179 = new LeetCode179();
		int[] nums = new int[] {41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
		System.out.println(leetCode179.largestNumber(nums));
	}
}
