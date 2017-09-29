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
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        String xorStr = Integer.toBinaryString(xor);
        int result = 0;
        for(int i = 0; i < xorStr.length(); i++) {
        	if ('1' == xorStr.charAt(i)) {
				result++;
			}
        }
        return result;
    }
    
    public static void main(String[] args) {
		HammingDistance hammingDistance = new HammingDistance();
		System.out.println(hammingDistance.hammingDistance(1, 4));
	}
}
