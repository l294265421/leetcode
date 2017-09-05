package leetcode438;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
Given a string s and a non-empty string p, find all the start indices of p's anagrams 
in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 * @author liyuncong
 *
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
       char[] charOfp = p.toCharArray();
       Arrays.sort(charOfp);
       List<Integer> result = new LinkedList<>();
       for(int i = 0; i <= s.length() - p.length(); i++) {
    	   if (isAnagram(s.substring(i, i + p.length()), charOfp)) {
    		   result.add(i);
    	   }
       }
       return result;
    }
    
    public boolean isAnagram(String subStr, char[] p) {
		char[] charOfSubStr = subStr.toCharArray();
		Arrays.sort(charOfSubStr);
		for(int i = 0; i < charOfSubStr.length; i++) {
			if (charOfSubStr[i] != p[i]) {
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
		FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
		System.out.println(findAllAnagramsInAString.findAnagrams("abab", "ab"));
	}
}
