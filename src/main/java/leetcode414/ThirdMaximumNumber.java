package leetcode414;

import java.util.TreeSet;

/**
 * 
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

Example 2:

Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 * @author liyuncong
 *
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
    	TopThree topThree = new TopThree();
        for(int i = 0; i < nums.length; i++) {
        	topThree.addElement(nums[i]);
        }
        if (topThree.size() == 3) {
			return topThree.min();
		} else {
			return topThree.max();
		}
    }
    
    private static class TopThree {
    	private TreeSet<Integer> topThree = new TreeSet<>();
    	
    	public void addElement(int num) {
			topThree.add(num);
			if (topThree.size() > 3) {
				topThree.pollFirst();
			}
		}
    	
    	public int size() {
			return topThree.size();
		}
    	
    	public int min() {
			return topThree.first();
		}
    	
    	public int max() {
			return topThree.last();
		}
    }
}
