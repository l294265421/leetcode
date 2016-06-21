package leetcode283;

/**
 * 
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

 * @author liyuncong
 *
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
    	moveZeroesStrategy2(nums);
    }
    
    public void moveZeroesStrategy1(int[] nums) {
    	if (nums == null) {
			return;
		}
    	int len = nums.length;
    	if (len <= 1) {
			return;
		}
        int leftZeroIndex = len;
        for(int i = len -1; i >= 0; i--) {
        	if (nums[i] == 0) {
				leftZeroIndex--;
				for(int j = i; j < leftZeroIndex; j++) {
					nums[j] = nums[j + 1];
				}
				nums[leftZeroIndex] = 0;
			}
        }
    }
    
    /**
     * 实际上移动非0元素
     * @param nums
     */
    public void moveZeroesStrategy2(int[] nums) {
    	if (nums == null) {
			return;
		}
    	int len = nums.length;
    	if (len <= 1) {
			return;
		}
        int rightNonZeroIndex = -1;
        for(int i = 0; i < len; i++) {
        	if (nums[i] != 0) {
				rightNonZeroIndex++;
				int temp = nums[rightNonZeroIndex];
				nums[rightNonZeroIndex] = nums[i];
				nums[i] = temp;;
			}
        }
    }
    
    public static void main(String[] args) {
		MoveZeroes moveZeroes = new MoveZeroes();
		int[] nums = new int[] {1,0};
		moveZeroes.moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
