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
public class LongestPalindrome2 {
    public int longestPalindrome(String s) {
        char chars[] = s.toCharArray();
        int lowerCase[] = new int[26];
        int upperCase[] = new int[26];
        int odds = 0;
        int n = s.length();
        
        for (int i=0; i<n; i++) {
            if (chars[i] < 'a') 
            	upperCase[chars[i]-'A'] ++;
            else 
            	lowerCase[chars[i]-'a'] ++;
        }
        
        for (int i=0; i<26; i++) {
            if (lowerCase[i]%2==1) odds++;
            if (upperCase[i]%2==1) odds++;
        }
        
        if (odds == 0) return n;
        else return n-odds+1;
    }
    
    public static void main(String[] args) {
		LongestPalindrome2 longestPalindrome = new LongestPalindrome2();
		System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
	}
}
