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
public class HammingDistance2 {
    public int hammingDistance(int x, int y) {
        int xor=x^y;
        int count=0;
        while(xor != 0){
            xor &= xor - 1;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
		HammingDistance2 hammingDistance = new HammingDistance2();
		System.out.println(hammingDistance.hammingDistance(1, 4));
		int i = 500;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(i - 1));
		System.out.println(Integer.toBinaryString((i - 1) & i));
	}
}
