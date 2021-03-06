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
public class LeetCode89 {
    public List<Integer> grayCode(int n) {
    	List<Integer> r = new ArrayList<Integer>();
    	List<List<Integer>> result = classify(n);
    	
    	r.add(0);
    	
    	int preClass = 0;
    	
    	int nsquare = (int) Math.pow(2, n);
    	for(int i = 1; i <= nsquare; i++) {
    		int candidate1 = preClass - 1;
    		int candidate2 = preClass + 1;
    		// 优先选取candidate1，只有在candidate1没有元素了才去取
    		// candidate2的元素
    		if (candidate1 > 0 && result.get(candidate1).get(0) < 
    				result.get(candidate1).size()) {
				r.add(result.get(candidate1).get(result.get(candidate1).get(0)));
				result.get(candidate1).set(0, result.get(candidate1).get(0) + 1);
				preClass = candidate1;
			} else if(candidate2 <= n && result.get(candidate2).get(0) < 
    				result.get(candidate2).size()) {
				r.add(result.get(candidate2).get(result.get(candidate2).get(0)));
				result.get(candidate2).set(0, result.get(candidate2).get(0) + 1);
				preClass = candidate2;
			}
    		
    	}
    	
    	return r;
    }
	
	/**
	 * 给数字按包含1的个数分类
	 * @param n 二进制位数
	 * @return
	 */
	public  List<List<Integer>> classify(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i <= n; i++) {
			List<Integer> element = new ArrayList<Integer>();
			// 第一个元素用于保存该类中下一个被获取元素的位置
			element.add(1);
			result.add(element);
		}
		
		int nsquare = (int) Math.pow(2, n);
		for(int i = 0; i < nsquare; i++) {
			String numBinaryStr = Integer.toBinaryString(i);
			int countOne = countOne(numBinaryStr);
			result.get(countOne).add(i);
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
			int countOne = countOne(integer.toBinaryString(integer));
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
		LeetCode89 leetCode89 = new LeetCode89();
		int n = 20;
		List<Integer> result = leetCode89.grayCode(n);
		System.out.println(check(result));
	}
}


