package leetcode258;

/**
Given a non-negative integer num, repeatedly add all its digits until the result has 
only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit,
 return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 

https://en.wikipedia.org/wiki/Digital_root
 * @author liyuncong
 *
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
			return num;
		}
        int newSum = 0;
        while (num != 0) {
			newSum += num % 10;
			num /= 10;
		}
        return addDigits(newSum);
    }
    
    public static void main(String[] args) {
		AddDigits addDigits = new AddDigits();
		System.out.println(addDigits.addDigits(38));
	}
}
