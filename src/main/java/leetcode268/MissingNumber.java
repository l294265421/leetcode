package leetcode268;

/**
 * 
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find 
the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it 
using only constant extra space complexity? 
 * @author liyuncong
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        // 把每一个元素都放回它应该在的位置
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] == i) {
				continue;
			}
        	int current = nums[i];
        	nums[i] = -1;
        	do {
        		if (current == nums.length) {
					break;
				}
				int temp = nums[current];
				nums[current] = current;
				current = temp;
			} while (current != -1);
        }
        int result = nums.length;
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] == -1) {
				result = i;
				break;
			}
        }
        return result;
    }
    
    public static void main(String[] args) {
		MissingNumber missingNumber = new MissingNumber();
		int[] nums = new int[] {0, 1, 4, 3};
		System.out.println(missingNumber.missingNumber(nums));
	}
}
