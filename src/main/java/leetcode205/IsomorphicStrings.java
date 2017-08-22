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
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
    	int[] sClass = classify(s);
    	int[] tClass = classify(t);
    	for(int i = 0; i < s.length(); i++) {
    		if (sClass[i] != tClass[i]) {
				return false;
			}
    	}
    	return true;
    }
    
    /**
     * 给s中的每个字符分个类，类别用数字0到k表示，其中k<=s.length
     * @param s
     * @return
     */
    private int[] classify(String s) {
		int[] result = new int[s.length()];
		Map<Character, Integer> charAndClass = new HashMap<>();
		int currentClass = 0;
		for(int i = 0; i < s.length(); i++) {
			Integer thisClass = charAndClass.get(s.charAt(i));
			if (thisClass == null) {
				thisClass = currentClass++;
				charAndClass.put(s.charAt(i), thisClass);
			}
			result[i] = thisClass;
		}
		return result;
	}
    
    public static void main(String[] args) {
		IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
		System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
	}
}
