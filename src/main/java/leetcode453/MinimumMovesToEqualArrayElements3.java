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
public class MinimumMovesToEqualArrayElements3 {
    public int minMoves(int[] nums) {
    	int result = 0;
        // 每次增加除最大数之外的所有数，让小的增加得更快，贪心算法
    	int move = 0;
    	int preMax = Integer.MAX_VALUE;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
			if (nums[i] < min) {
				min = nums[i];
			}
		}
    	move = max - min;
    	while (move != 0) {
    		result += move;
    		preMax = max;
    		max = Integer.MIN_VALUE;
    		boolean skip = false;
			for(int i = 0; i < nums.length; i++) {
				if (nums[i] != preMax) {
					nums[i] += move;
				} else {
					if (!skip) {
						skip = true;
					} else {
						nums[i] += move;
					}
				}
				if (nums[i] > max) {
					max = nums[i];
				}
			}
			move = max - preMax;
		}
    	return result;
    }
    
    public static void main(String[] args) {
		MinimumMovesToEqualArrayElements3 minimumMovesToEqualArrayElements = new MinimumMovesToEqualArrayElements3();
		int[] nums = new int[] {1,2,3};
		System.out.println(minimumMovesToEqualArrayElements.minMoves(nums));
	}
}
