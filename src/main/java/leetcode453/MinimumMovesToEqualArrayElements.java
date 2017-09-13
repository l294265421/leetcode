package leetcode453;

/**
 * 
Given a non-empty integer array of size n, find the minimum number of moves required to 
make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 * @author liyuncong
 *
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
    	int result = 0;
        // 每次增加除最大数之外的所有数，让小的增加得更快，贪心算法
    	while (!allEqual(nums)) {
			move(nums);
			result++;
		}
    	return result;
    }
    
    private void move(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		boolean skip = false;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] <= max) {
				if (nums[i] < max) {
					nums[i]++;
				} else {
					if (!skip) {
						skip = true;
					} else {
						nums[i]++;
					}
				}
			}
		}
	}
    
    private boolean allEqual(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max == min;
	}
    
    public static void main(String[] args) {
		MinimumMovesToEqualArrayElements minimumMovesToEqualArrayElements = new MinimumMovesToEqualArrayElements();
		int[] nums = new int[] {1,2,3};
		System.out.println(minimumMovesToEqualArrayElements.minMoves(nums));
	}
}
