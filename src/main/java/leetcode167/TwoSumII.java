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
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
        out: for(int i = 0; i < numbers.length; i++) {
        	if (numbers[i] > target) {
				break;
			}
        	for(int j = i + 1; j < numbers.length; j++) {
        		if (numbers[i] + numbers[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					break out;
				} else if (numbers[i] + numbers[j] > target) {
					break;
				}
        	}
        }
    	return result;
    }
    
    public static void main(String[] args) {
		TwoSumII twoSumII = new TwoSumII();
		int[] numbers = new int[] {2, 7, 11, 15};
		int[] result = twoSumII.twoSum(numbers, 9);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
