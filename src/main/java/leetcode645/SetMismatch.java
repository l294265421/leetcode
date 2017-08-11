package leetcode645;

import java.util.Arrays;

/**
 * 
The set S originally contains numbers from 1 to n. But unfortunately, due to the data 
error, one of the numbers in the set got duplicated to another number in the set, 
which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your 
task is to firstly find the number occurs twice and then find the number that is 
missing. Return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Note:

    The given array size will in the range [2, 10000].
    The given array's numbers won't have any order.

 * @author liyuncong
 *
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] helper = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	int temp = helper[nums[i] - 1];
        	if (temp != 0) {
				result[0] = temp;
			}
        	helper[nums[i] - 1] = nums[i]; 
        }
        for(int i = 0; i < helper.length; i++) {
        	if (helper[i] == 0) {
				result[1] = i + 1;
				break;
			}
        }
        return result;
    }
    public static void main(String[] args) {
		int[] nums = new int[]{1,2,2,4};
		SetMismatch setMismatch = new SetMismatch();
		int[] result = setMismatch.findErrorNums(nums);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
