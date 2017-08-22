package leetcode205;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while 
preserving the order of characters. No two characters may map to the same character 
but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 * @author liyuncong
 *
 */
public class IsomorphicStrings2 {
	public boolean isIsomorphic(String s, String t) {
		int[] m = new int[512];
		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();

		for (int i = 0; i < s1.length; i++) {
			// 再次遇到s1[i]时，如果没办法替换，返回而false
			if (m[s1[i]] != m[s2[i] + 256])
				return false;
			// 第一次遇到s1[i]，s1[i]和s2[i]都用s1[i]表示，也就是替换
			m[s1[i]] = m[s2[i] + 256] = s1[i];
		}

		return true;
	}
    
    public static void main(String[] args) {
		IsomorphicStrings2 isomorphicStrings = new IsomorphicStrings2();
		System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
	}
}
