package leetcode345;

public class LeetCode345 {
    public String reverseVowels(String s) {
    	if (s == null) {
			return null;
		}
		int len = s.length();
		if (len <= 1) {
			return s;
		}
		char[] chars = stringToCharArray(s);
		// 从前往后找元音
		for(int start = 0, end = len - 1; start < end; start++) {
			char fore = chars[start];
			if (isVowel(fore)) {
				// 从后往前找元音
				for(; end > start; end--) {
					char hind = chars[end];
					if (isVowel(hind)) {
						chars[end] = fore;
						chars[start] = hind;
						end--;
						break;
					}
				}
			}
		}
		
		return charArrayToString(chars);
    }
    
    private boolean isVowel(char c) {
    	String vowels = "aeiouAEIOU";
    	if (vowels.indexOf(c) == -1) {
			return false;
		}
    	return true;
    }
    
    private char[] stringToCharArray(String s) {
		if (s == null) {
			return null;
		}
		int len = s.length();
		if (len == 0) {
			return null;
		}
		char[] result = new char[len];
		for(int i = 0; i < len; i++) {
			result[i] = s.charAt(i);
		}
		return result;
	}
    
    private String charArrayToString(char[] chars) {
		if (chars == null) {
			return "";
		}
		int len = chars.length;
		if (len == 0) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < len; i++) {
			stringBuilder.append(chars[i]);
		}
		return stringBuilder.toString();
	}
    
    public static void main(String[] args) {
		LeetCode345 leetCode345 = new LeetCode345();
		System.out.println(leetCode345.reverseVowels("leetcode"));
	}
}
