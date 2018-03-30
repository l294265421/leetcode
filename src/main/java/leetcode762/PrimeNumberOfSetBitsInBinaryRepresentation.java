package leetcode762;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 Given two integers L and R, find the count of numbers in the range [L, R] 
 (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present 
when written in binary. For example, 21 written in binary is 10101 which has 3 
set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)

Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)

Note:

    L, R will be integers L <= R in the range [1, 10^6].
    R - L will be at most 10000.

 * @author liyuncong
 *
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int[] primeNumFlag = new int[32];
        primeNumFlag[2] = 1;
        primeNumFlag[3] = 1;
        primeNumFlag[5] = 1;
        primeNumFlag[7] = 1;
        primeNumFlag[11] = 1;
        primeNumFlag[13] = 1;
        primeNumFlag[17] = 1;
        primeNumFlag[19] = 1;
        primeNumFlag[23] = 1;
        primeNumFlag[29] = 1;
        primeNumFlag[31] = 1;
        int result = 0;
        for(int i = L; i <= R; i++) {
        	if (primeNumFlag[setBitCount(i)] == 1) {
				result++;
			}
        }
        return result;
    }
    
    private int setBitCount(int integer) {
		int result = 0;
		int temp = integer;
		while (temp != 0) {
			if ((temp & 1) == 1) {
				result++;
			}
			temp = temp >> 1;
		}
		return result;
	}
    
    public static void main(String[] args) {
		PrimeNumberOfSetBitsInBinaryRepresentation primeNumberOfSetBitsInBinaryRepresentation = 
				new PrimeNumberOfSetBitsInBinaryRepresentation();
		System.out.println(primeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(6, 10));
		System.out.println(primeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(10, 15));

    }
}
