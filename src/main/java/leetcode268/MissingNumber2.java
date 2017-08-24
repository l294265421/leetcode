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
public class MissingNumber2 {
	/**
	 * 厉害，0到n的和，减去nums中元素的和
	 * @param nums
	 * @return
	 */
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        
        long sum = (nums.length)*(nums.length+1)/2;
        for(int i=0; i<nums.length;i++){
            sum -= (long)nums[i];
        }
        
        return (int)sum;
    }
    
    public static void main(String[] args) {
		MissingNumber2 missingNumber = new MissingNumber2();
		int[] nums = new int[] {0, 1, 4, 3};
		System.out.println(missingNumber.missingNumber(nums));
	}
}
