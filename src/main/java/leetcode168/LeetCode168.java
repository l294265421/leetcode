package leetcode168;

import java.util.LinkedList;

/**
 * 26有两种表示法：Z和A_；
 * 用余数得到对应位置的字母；
 * n / 26 = result, n % 26 = remainder, 
 * if remainder == 0 result--, letter = Z,
 * if remainder != 0, reaminder -> letter,
 * n == 0, end
 * @author liyuncong
 *
 */
public class LeetCode168 {
    public String convertToTitle(int n) {
    	if (n == 0) {
			return "";
		}
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (n != 0) {
			int result = n / 26;
			int remainder = n % 26;
			if (remainder == 0) {
				result--;
				stack.add(26);
			} else {
				stack.push(remainder);;
			}
			n = result;
		}
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
			Integer top = stack.pop();
			stringBuilder.append(letters.charAt(top - 1));
		}
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
		LeetCode168 leetCode168 = new LeetCode168();
		System.out.println(leetCode168.convertToTitle(52));
	}
}
