package leetcode342;

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
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
    	if (num < 1) {
			return false;
		}
        if (num == 1) {
			return true;
		}
        long current = 4;
        boolean result = false;
        while (current <= num) {
			if (current == num) {
				result = true;
				break;
			}
			current = current << 2;
		}
        return result;
    }
    
    public static void main(String[] args) {
		PowerOfFour powerOfFour = new PowerOfFour();
		System.out.println(powerOfFour.isPowerOfFour(15));
	}
}
