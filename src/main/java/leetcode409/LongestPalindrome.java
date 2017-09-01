package leetcode409;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Given a string which consists of lowercase or uppercase letters, find the length of 
the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 * @author liyuncong
 *
 */
public class LongestPalindrome {
	/**
	 * 也就是找到有多少对字幕
	 * @param s
	 * @return
	 */
    public int longestPalindrome(String s) {
        Map<Character, Integer> charAndCount = new HashMap<>();
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
        	Integer temp = charAndCount.get(s.charAt(i));
        	if (temp == null) {
				charAndCount.put(s.charAt(i), 1);
			} else {
				result++;
				charAndCount.remove(s.charAt(i));
			}
        }
        result *= 2;
        if (result < s.length()) {
			result++;
		}
        return result;
    }
    
    public static void main(String[] args) {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
	}
}
