package leetcode242;

import java.util.Arrays;

/**
 * 
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author liyuncong
 *
 */
public class LeetCode242 {
	private static EqualStragedy LENGTH_EQUAL = new LengthEqual();
	private static EqualStragedy CHAR_VALUE_SUM_IN_STRING_EQUAL = new CharValueSumInStringEqual();
	private static EqualStragedy IS_ANAGRAM = new IsAnagram();
	
    public boolean isAnagram(String s, String t) {
        return LENGTH_EQUAL.equal(s, t) 
        		&& CHAR_VALUE_SUM_IN_STRING_EQUAL.equal(s, t) 
        		&& IS_ANAGRAM.equal(s, t);
    }
    
    private interface EqualStragedy {
    	public boolean equal(String s, String t);
    }
    
    private static class LengthEqual implements EqualStragedy {

		@Override
		public boolean equal(String s, String t) {
			if (s == null || t == null) {
				return false;
			}
			
			if (s.length() == t.length()) {
				return true;
			}
			
			return false;
		}
    	
    }
    
    public static class CharValueSumInStringEqual implements EqualStragedy {

		@Override
		public boolean equal(String s, String t) {
			if (s == null || t == null) {
				return false;
			}
			
			int sumOfS = charValueSumInString(s);
			int sumOfT = charValueSumInString(t);
			if (sumOfS == sumOfT) {
				return true;
			}
			
			return false;
		}
		
		private int charValueSumInString(String s) {
			if (s == null) {
				return 0;
			}
			
			int result = 0;
			int len = s.length();
			for(int i = 0; i < len; i++) {
				result += s.charAt(i);
			}
			return result;
		}
    	
    }
    
    public static class IsAnagram implements EqualStragedy {

		@Override
		public boolean equal(String s, String t) {
			if (s == null || t == null) {
				return false;
			}
			
			char[] charArrayOfS = stringToCharArray(s);
			char[] charArrayOfT = stringToCharArray(t);
			
			if (charArrayOfS != null) {
				Arrays.sort(charArrayOfS);
			}
			if (charArrayOfT != null) {
				Arrays.sort(charArrayOfT);
			}
			return Arrays.equals(charArrayOfS, charArrayOfT);
		}
    	
		/**
		 * 
		 * @param s 
		 * @return 返回s中所有字符组成的数组，如果s为null或者长度为0，返回null
		 */
		private char[] stringToCharArray(String s) {
			if (s == null || s.length() == 0) {
				return null;
			}
			
			int len = s.length();
			char[] result = new char[len];
			for(int i = 0; i < len; i++) {
				result[i] = s.charAt(i);
			}
			return result;
		} 
    }
    
    public static void main(String[] args) {
		LeetCode242 leetCode242 = new LeetCode242();
		String s = "abdc";
		String t = "dbac";
		System.out.println(leetCode242.isAnagram(s, t));
	}
}
