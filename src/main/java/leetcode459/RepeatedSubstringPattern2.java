package leetcode459;

/**
 * 


Given a non-empty string check if it can be constructed by taking a substring of it and 
appending multiple copies of the substring together. You may assume the given string 
consists of lowercase English letters only and its length will not exceed 10000.

Example 1:

Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.

Example 2:

Input: "aba"

Output: False

Example 3:

Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


 * @author liyuncong
 *
 */
public class RepeatedSubstringPattern2 {
    public boolean repeatedSubstringPattern(String s) {
    	// i是子串长度
    	for(int i = s.length() / 2; i > 0; i--){
    		if(s.length() % i== 0 && s.endsWith(s.substring(0, i))){
    			if(isPart(s.substring(0, i),s))
    				return true;
    		}
    	}
		return false;
        
    }
	private boolean isPart(String sub, String s) {
		while(s.startsWith(sub) && s.length() >= sub.length())
			s = s.substring(sub.length(),s.length());
		if(s.equals(""))
			return true;
		else
			return false;
	}
    
    public static void main(String[] args) {
		RepeatedSubstringPattern2 repeatedSubstringPattern = new RepeatedSubstringPattern2();
		System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
	}
}
