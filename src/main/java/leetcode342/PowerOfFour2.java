package leetcode342;

import leetcode231.PowerOfTwo3;

/**
 * 
Given an integer (signed 32 bits), write a function to check whether it is a power 
of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion? 
 * @author liyuncong
 *
 */
public class PowerOfFour2 {
	/**
	 * Good solution without good explanation,it's easy to find that power of 4 
	 * numbers have those 3 common features.First,greater than 0.Second,only 
	 * have one '1' bit in their binary notation,so we use x&(x-1) to delete the 
	 * lowest '1',and if then it becomes 0,it prove that there is only one '1' bit.
	 * Third,the only '1' bit should be locate at the odd location,for example,16.
	 * It's binary is 00010000.So we can use '0x55555555' to check if the '1' bit 
	 * is in the right place.With this thought we can code it out easily!
	 * @see PowerOfTwo3
	 * @param num
	 * @return
	 */
    public boolean isPowerOfFour(int num) {
    	 return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
    
    public static void main(String[] args) {
		PowerOfFour2 powerOfFour = new PowerOfFour2();
		System.out.println(powerOfFour.isPowerOfFour(15));
	}
}
