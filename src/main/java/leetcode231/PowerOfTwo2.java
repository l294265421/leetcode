package leetcode231;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two. 
 * @author liyuncong
 *
 */
public class PowerOfTwo2 {
	public boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;
		// 2^n必能被1073741824整除，但是如何证明能被它整除的数都是2^n呢?
		if (1073741824 % n == 0)
			return true;
		else
			return false;
	}
    
    public static void main(String[] args) {
		PowerOfTwo2 powerOfTwo = new PowerOfTwo2();
		System.out.println(powerOfTwo.isPowerOfTwo(1073741825));
	}
}
