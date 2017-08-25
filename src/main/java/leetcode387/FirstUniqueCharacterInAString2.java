package leetcode387;

/**
 * 
Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
 * @author liyuncong
 *
 */
public class FirstUniqueCharacterInAString2 {
    public int firstUniqChar(String s) {
        char[] chars = new char[26];
        int currentIndex = 0;
        int[] occurTimes = new int[26];
        for(int i = 0; i < s.length(); i++) {
        	occurTimes[s.charAt(i) - 'a']++;
        	if (occurTimes[s.charAt(i) - 'a'] == 1) {
				chars[currentIndex++] = s.charAt(i);
			}
        }
        int result = -1;
        for(int i = 0; i < currentIndex; i++) {
        	if (occurTimes[chars[i] - 'a'] == 1) {
				result = s.indexOf(chars[i]);
				break;
			}
        }
        return result;
    }
    
    public static void main(String[] args) {
		FirstUniqueCharacterInAString2 firstUniqueCharacterInAString = new 
				FirstUniqueCharacterInAString2();
		System.out.println(firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));
	}
}
