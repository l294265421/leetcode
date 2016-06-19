package leetcode191;

/**
 * 
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * @author yuncong
 *
 */
public class LeetCode191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
    	int mask = 1;
    	while(n != 0) {
    		int temp = n & mask;
    		if (temp == 1) {
				result++;
			}
    		n = n >>> 1;
    	}
        return result;
    }
    
    public static void main(String[] args) {
		LeetCode191 leetCode191 = new LeetCode191();
		System.out.println(leetCode191.hammingWeight(11));
	}
}
