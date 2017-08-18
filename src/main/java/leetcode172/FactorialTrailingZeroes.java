package leetcode172;

/**
 * 
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 * @author liyuncong
 *
 */
public class FactorialTrailingZeroes {
	/**
	 * http://www.purplemath.com/modules/factzero.htm
	 * @param n
	 * @return
	 */
    public int trailingZeroes(int n) {
        int s = 0;
        // 5的倍数的数的个数，5^2的倍数的个数...加起来
        while (n>4) 
        	s += (n/=5);
        return s;
    }
}
