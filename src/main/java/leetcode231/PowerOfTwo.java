package leetcode231;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two. 
 * @author liyuncong
 *
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
    	if (n == 1) {
			return true;
		}
    	long current = 2;
    	while (current <= n) {
    		System.out.println(Long.toBinaryString(current));
    		System.out.println(Long.toBinaryString(current - 1));
			if (current == n) {
				return true;
			} else {
				current = current << 1;
			}
		}
    	return false;
    }
    
    public static void main(String[] args) {
		PowerOfTwo powerOfTwo = new PowerOfTwo();
		System.out.println(powerOfTwo.isPowerOfTwo(1073741825));
	}
}
