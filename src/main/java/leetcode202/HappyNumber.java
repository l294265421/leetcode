package leetcode202;

import java.util.HashSet;
import java.util.Set;

/**
 * 
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

 * @author liyuncong
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n < 0) {
			return false;
		}
        Set<Integer> numbers = new HashSet<>();
        while (n != 1 && !numbers.contains(n)) {
        	numbers.add(n);
			n = sumOfSquaresOfNumberDigits(n);
		}
        if (n == 1) {
			return true;
		} else {
			return false;
		}
    }
    
    /**
     * 
     * @param n 大于等于0的整数
     * @return n的各数字的平方和
     */
    private int sumOfSquaresOfNumberDigits(int n) {
		int sum = 0;
		while (n != 0) {
			int remainder = n % 10;
			sum += remainder * remainder;
			n /= 10;
		}
		return sum;
	}
    
    public static void main(String[] args) {
		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.isHappy(19));
	}
}
