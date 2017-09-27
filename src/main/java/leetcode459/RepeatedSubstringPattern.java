package leetcode459;

/**
 * 


Given a non-empty string check if it can be constructed by taking a substring of it and 
appending multiple copies of the substring together. You may assume the given string 
consists of lowercase English letters only and its length will not exceed 10000.

Example 1:

Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.

Example 2:

Input: "aba"

Output: False

Example 3:

Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


 * @author liyuncong
 *
 */
public class RepeatedSubstringPattern {
	/**
	 * 检查s是否是有2个、3个...相同的字符串拼接而成
	 * @param s
	 * @return
	 */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int partsNum = 2;
        boolean result = false;
        while (partsNum <= len) {
			out: if (len % partsNum == 0) {
				int partLen = len / partsNum;
				for(int i = 1; i < partsNum; i++) {
					if (!s.substring(i * partLen, (i + 1) * partLen)
							.equals(s.substring((i - 1) * partLen, i * partLen))) {
						break out;
					}
				}
				result = true;
				break;
			}
			partsNum++;
		}
        return result;
    }
    
    public static void main(String[] args) {
		RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
		System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
	}
}
