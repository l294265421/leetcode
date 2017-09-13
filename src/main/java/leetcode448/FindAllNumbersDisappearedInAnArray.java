package leetcode448;

import java.util.LinkedList;
import java.util.List;

/**
 * 
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear 
twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned 
list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 * @author liyuncong
 *
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	if (num != i + 1 && num != -1) {
				nums[i] = -1;
			} else {
				continue;
			}
        	int preNum;
        	do {
        		preNum = num;
				int temp = nums[num - 1];
				nums[num - 1] = num;
				num = temp;
			} while (num != preNum && num != -1);
        }
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] == -1) {
				result.add(i + 1);
			}
        }
        return result;
    }
    
    public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
		int[] nums = new int[] {1,1,2,2};
		System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums));
	}
}
