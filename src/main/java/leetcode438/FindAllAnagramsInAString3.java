package leetcode438;

import java.util.ArrayList;
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
public class FindAllAnagramsInAString3 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int[] pCount = new int[26];
        int[] count = new int[26];
        for (int i = 0;i<cp.length;i++) {
            pCount[cp[i]-'a']++;
        }
        for (int i = 0;i<cp.length-1;i++) {
            count[cs[i]-'a']++;
        }
        for (int i = 0;i<cs.length-cp.length+1;i++){
            boolean flag =true;
            // 向右移动一个位置，统计信息count只有cs[i+cp.length-1]-'a'和count[cs[i]-'a']围上上的信息需要
            // 改变
            count[cs[i+cp.length-1]-'a']++;
            for (int j = 0;j<26;j++) {
                if (count[j] != pCount[j]) {
                    flag = false;
                    break;
                }
            }
            count[cs[i]-'a']--;
            if (flag) {
                list.add(i);
            }       
        }
        return list;
    }
    
    public static void main(String[] args) {
		FindAllAnagramsInAString3 findAllAnagramsInAString = new FindAllAnagramsInAString3();
		System.out.println(findAllAnagramsInAString.findAnagrams("abab", "ab"));
	}
}
