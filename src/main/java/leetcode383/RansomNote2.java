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
public class RansomNote2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || magazine.length() < ransomNote.length()) return false;
        int[] letters = new int[26];
        for (char c : magazine.toCharArray()) {
            int i = c - 'a';
            letters[i]++;
        }
        for (char c : ransomNote.toCharArray()) {
            int i = c - 'a';
            if (--letters[i] < 0) 
            	return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
		RansomNote2 ransomNote = new RansomNote2();
		System.out.println(ransomNote.canConstruct("aa", "ab"));
	}
}
