package leetcode189;

public class LeetCode189 {
	public void rotate(int[] nums, int k) {
		int step = k % (nums.length);
		method3(nums, step);
	}

	/**
	 * 全部顺序移动一步，移动k次，O(n);
	 *  Time Limit Exceeded
	 * @param nums
	 * @param k
	 */
	public void method1(int[] nums, int k) {
		int len = nums.length;
		for(int i = 0; i < k; i++) {
			int last = nums[len - 1];
			for(int j = len - 2; j >= 0; j--) {
				nums[j + 1] = nums[j];
			}
			nums[0] = last;
		}
	}
	
	/**
	 * 克隆数组nums，把元素一次放回原数组中正确的位置,O(n)
	 * @param nums
	 * @param k
	 */
	public void method2(int[] nums, int k) {
		int[] temp = nums.clone();
		int len = temp.length;
		for(int i = 0; i < len; i++) {
			int rightPosition = (i + k) % len;
			nums[rightPosition] = temp[i];
		}
	}
	
	/**
	 * 旋转k，意味着，后面k个元素跑到前面去了，（1）前面n-k个元素跑到后面来了，（2）
	 * 并保持顺序；
	 * 三次反转，先整个反转，满足了第一条；然后先反转前k个，后反转后n-k个，满足了第二条。
	 * @param nums
	 * @param k
	 */
	public void method3(int[] nums, int k) {
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	
	/**
	 * 反转数组中start和end之间的元素，开头结尾都包含；
	 * @param nums
	 * @param start
	 * @param end
	 */
	private void reverse(int[] nums, int start, int end) {
		int bound = (start + end + 1) / 2;
		int count = 0;
		for(int i = start; i < bound; i++) {
			int temp = nums[i];
			nums[i] = nums[end - count];
			nums[end - count] = temp;
			count++;
		}
	}
	
	public static void main(String[] args) {
		LeetCode189 leetCode189 = new LeetCode189();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		leetCode189.reverse(nums, 1, 5);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
