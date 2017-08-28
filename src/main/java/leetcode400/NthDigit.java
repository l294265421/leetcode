package leetcode400;

/**
 * 
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).

Example 1:

Input:
3

Output:
3

Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 * @author liyuncong
 *
 */
public class NthDigit {
    public int findNthDigit(int n) {
        // k位数字有 k * 9 * 10 ^ (k - 1)
    	
    	// 先找到对应数字
    	int k = 1;
    	int digitNum = 0;
    	int num = 0;
    	while (digitNum + (k * 9 * Math.pow(10, k - 1)) < n) {
    		digitNum += k * 9 * Math.pow(10, k - 1);
    		num += 9 * Math.pow(10, k - 1);
			k++;
		}
    	num += (n - digitNum) / k;
    	int remainder = (n - digitNum) % k;
    	if (remainder == 0) {
			return num % 10;
		} else {
			return Integer.parseInt(String.valueOf(num + 1).substring(remainder - 1, remainder));
		}
    	
    }
	
	public static void main(String[] args) {
		NthDigit nthDigit = new NthDigit();
		System.out.println(nthDigit.findNthDigit(10));
	}
}
