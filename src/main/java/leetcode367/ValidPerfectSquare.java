package leetcode367;

/**
 * 
Given a positive integer num, write a function which returns True if num is a perfect 
square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True

Example 2:

Input: 14
Returns: False

 * @author liyuncong
 *
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        boolean result = false;
        while (start <= end) {
			int mid = start + (end - start) / 2;
			long square = mid * (long)mid;
			if (square == num) {
				result = true;
				break;
			} else if (square < num){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
        return result;
    }
    
    public static void main(String[] args) {
		ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
		System.out.println(validPerfectSquare.isPerfectSquare(4));
	}
}
