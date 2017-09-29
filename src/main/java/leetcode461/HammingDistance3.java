package leetcode461;

/**
 * 
The Hamming distance between two integers is the number of positions at which the 
corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

 * @author liyuncong
 *
 */
public class HammingDistance3 {
    public int hammingDistance(int x, int y) {
    	 int xor = x ^ y, count = 0;
    	    for (int i=0;i<32;i++) 
    	    	count += (xor >> i) & 1;
    	    return count;
    }
    
    public static void main(String[] args) {
		HammingDistance3 hammingDistance = new HammingDistance3();
		System.out.println(hammingDistance.hammingDistance(1, 4));
		int i = 500;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(i - 1));
		System.out.println(Integer.toBinaryString((i - 1) & i));
	}
}
