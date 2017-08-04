package leetcode89;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the
 sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about
 that.
 * @author liyuncong
 *
 */
public class LeetCode891 {
	/**
	 * The idea is simple. G(i) = i^ (i/2).
	 * @param n
	 * @return
	 */
    public List<Integer> grayCode(int n) {
    	List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) {
        	result.add(i ^ i>>1);
        }
        return result;
    }
	
	private static int countOne(String numBinaryStr) {
		int result = 0;
		int len = numBinaryStr.length();
		for(int j = 0; j < len; j++) {
			if (numBinaryStr.charAt(j) == '1') {
				result++;
			}
		}
		return result;
	}
	
	private static boolean check(List<Integer> grayCode) {
		boolean result = true;
		int lastIntOneCount = 0;
		for (Integer integer : grayCode) {
			if (integer == 0) {
				continue;
			}
			int countOne = countOne(Integer.toBinaryString(integer));
			if (Math.abs(countOne - lastIntOneCount) != 1) {
				result = false;
				break;
			} else {
				lastIntOneCount = countOne;
			}
		}
		return result;
	}
	
	/**
	 * 字符串s左边添加一定数量的字符c,是的字符串的长度变为length
	 * @param c 
	 * @param length
	 * @param s
	 * @return
	 */
	private static String complete(char c, int length, String s) {
		int len = length - s.length();
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < len; i++) {
			result.append(c);
		}
		result.append(s);
		return result.toString();
	}
	
	public static void main(String[] args) {
		LeetCode891 leetCode89 = new LeetCode891();
		int n = 50;
		List<Integer> result = leetCode89.grayCode(n);
		System.out.println(check(result));
		
	}
}


