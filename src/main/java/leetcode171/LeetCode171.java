package leetcode171;

/**
 * 等于个元素作为权重乘以26^(length - 1 - index)之和
 * @author liyuncong
 *
 */
public class LeetCode171 {
    public int titleToNumber(String s) {
        int sum = 0;
        int len = s.length();
        int lenMinusOne = len - 1;
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < len; i++) {
        	int weight = letters.indexOf(s.charAt(i)) + 1;
			sum += weight * Math.pow(26, lenMinusOne - i);
		}
        return sum;
    }
}
