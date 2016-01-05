package leetcode162;

public class LeetCode162 {
	public int findPeakElement(int[] nums) {
		int len = nums.length;
		// num[i] < num[i+1]的结果
		boolean preCompareResult = true;
		for (int i = 0; i < len - 1; i++) {
			boolean compareResult = nums[i] < nums[i + 1];
			if (preCompareResult) {
				if (!compareResult) {
					// preCompareResult为真，compareResult
					// 为假时，nums[i]就是peekElement
					return i;
				}
			} else {
				preCompareResult = compareResult;
			}
		}
		if (preCompareResult) {
			return len - 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		LeetCode162 leetCode162 = new LeetCode162();
		System.out.println(leetCode162.findPeakElement(new int[]{1}));
	}
}
