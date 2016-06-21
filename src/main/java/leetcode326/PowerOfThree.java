package leetcode326;

/**
 * 
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 

{@link https://helloacm.com/cc-coding-exercise-power-of-three-leetcode/?utm_source=tuicool&utm_medium=referral}}
 * @author liyuncong
 *
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return isPowerOfThreeStrategy3(n);
    }
    
    private boolean isPowerOfThreeStrategy1(double n) {
    	if (n < 3) {
			if (n == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			n = n  / 3;
			return isPowerOfThreeStrategy1(n);
		}
	}
    
    private boolean isPowerOfThreeStrategy2(double n) {
    	while (n >= 3) {
			n /= 3;
		}
    	if (n == 1) {
			return true;
		} else {
			return false;
		}
	}
    
    private boolean isPowerOfThreeStrategy3(int n) {
    	if (n <= 0) {
			return false;
		}
    	
    	if (1162261467 % n == 0) {
			return true;
		} else {
			return false;
		}
	}
    
    public static void printAllPowerOfThree() {
    	int power = 0;
		while (true) {
			int result = (int) Math.pow(3, power);
			if (result == Integer.MAX_VALUE) {
				break;
			}
			System.out.println(result);
			power++;
		}
	}
    
    public static void main(String[] args) {
//    	printAllPowerOfThree();
    	PowerOfThree powerOfThree = new PowerOfThree();
    	System.out.println(powerOfThree.isPowerOfThree(8));
	}
}
