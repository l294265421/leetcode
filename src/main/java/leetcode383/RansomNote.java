package leetcode383;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Given an arbitrary ransom note string and another string containing letters from all the 
magazines, write a function that will return true if the ransom note can be constructed 
from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

 * @author liyuncong
 *
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charAndNum = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
        	Integer num = charAndNum.get(magazine.charAt(i));
        	if (num == null) {
				num = 0;
			}
        	charAndNum.put(magazine.charAt(i), num + 1);
        }
        boolean result = true;
        for(int i = 0; i < ransomNote.length(); i++) {
        	Integer num = charAndNum.get(ransomNote.charAt(i));
        	if (num == null || num < 1) {
				result = false;
				break;
			}
        	charAndNum.put(ransomNote.charAt(i), num - 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
		RansomNote ransomNote = new RansomNote();
		System.out.println(ransomNote.canConstruct("aa", "ab"));
	}
}
