package leetcode784;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:

    S will be a string with length at most 12.
    S will consist only of letters or digits.

 * @author liyuncong
 *
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
    	List<String> result = new ArrayList<>();
    	if (S == null) {
			return result;
		}
    	if (S.length() == 0) {
			result.add("");
			return result;
		}
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
        	char origion = (char) ('a' + i);
        	char substitute = (char) ('A' + i);
        	map.put(origion, substitute);
        	map.put(substitute, origion);
        }
        letterCasePermutation(S, 0, "", result, map);
        return result;
    }
    
    public void letterCasePermutation(String S, int index, String prefix, List<String> result, Map<Character, Character> map) {
    	if (index == S.length()) {
			result.add(prefix);
			return;
		}
    	char orgion = S.charAt(index);
    	letterCasePermutation(S, index + 1, prefix + orgion, result, map);
    	if (map.get(orgion) != null) {
			letterCasePermutation(S, index + 1, prefix + map.get(orgion), result, map);
		}
    }
    
    public static void main(String[] args) {
    	LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
		String S = "12345";
    	List<String> result = letterCasePermutation.letterCasePermutation(S);
    	for (String string : result) {
			System.out.println(string);
		}
    }
}
