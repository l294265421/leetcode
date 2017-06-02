package leetcode594;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
We define a harmonious array is an array where the difference between its 
maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest 
harmonious subsequence among all its possible subsequences.

Example 1:

Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Note: The length of the input array will not exceed 20,000. 
 * @author liyuncong
 *
 */
public class LongestHarmoniousSubsequence {
	/**
	 * 如果subsequence是原sequence中的元素按原来顺序组成的（一个排列），下面的实现方法
	 * 也能得到正确答案，因为sequence是其元素组合的一个。
	 * @param nums
	 * @return
	 */
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
        
        TreeMap<Integer, Integer> integerCount = new TreeMap<>();
        for(int num : nums) {
        	integerCount.put(num, integerCount.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        Entry<Integer, Integer> lastEntry = null;
        for(Entry<Integer, Integer> entry : integerCount.entrySet()) {
        	if (lastEntry == null) {
				lastEntry = entry;
				continue;
			}
        	if (entry.getKey() - lastEntry.getKey() == 1 
        			&& entry.getValue() + lastEntry.getValue() > result) {
				result = entry.getValue() + lastEntry.getValue();
			}
        	lastEntry = entry;
        }
        return result;
    }
    
    public static void main(String[] args) {
		LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
		int[] nums = new int[] {1,2,2,3,4,5,1,1,1,1};
		System.out.println(longestHarmoniousSubsequence.findLHS(nums));
	}
}
