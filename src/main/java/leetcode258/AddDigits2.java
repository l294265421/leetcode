package leetcode258;

/**
Given a non-negative integer num, repeatedly add all its digits until the result has 
only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit,
 return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 
 * @author liyuncong
 *
 */
public class AddDigits2 {
	/**
	 * https://en.wikipedia.org/wiki/Digital_root
	 * @param num
	 * @return
	 */
    public int addDigits(int num) {
    	return num - ((num - 1) / 9) * 9;
        
    }
    
    public static void main(String[] args) {
		AddDigits2 addDigits = new AddDigits2();
		System.out.println(addDigits.addDigits(38));
	}
}
