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
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;
        for (int i = 'a'; i <= 'z'; i++) {
            int idx = s.indexOf(i);
            if ((idx != -1) && (s.lastIndexOf(i) == idx)) {
                result = Math.min(result, idx);
            }
        }

        return result == Integer.MAX_VALUE? -1:result;
    }
    
    public static void main(String[] args) {
		FirstUniqueCharacterInAString firstUniqueCharacterInAString = new 
				FirstUniqueCharacterInAString();
		System.out.println(firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));
	}
}
