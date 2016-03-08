package leetcode290;

import java.util.HashMap;
import java.util.Map;

/**
 * 基本思想：用两个HashMap分别存储比较过的模式和对应的输入字符串，对每一对新来的模式和字符串
 * 只有两种情况需要继续比较：对应的HashMap的键集中都存有它们，且对应的值一样；对应的HashMap
 * 的键集中都不包含它们（这种情况，需要把它们及对应的索引号存进去）。
 * @author yuncong
 *
 */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> patterns = new HashMap<Character, Integer>();
        Map<String, Integer> inputs = new HashMap<String, Integer>();
        String[] seperateStr = str.split(" ");
        int len = seperateStr.length;
        if (len != pattern.length()) {
			return false;
		}
        boolean result = true;
        for(int i = 0; i < len; i++) {
        	Character temp = new Character(pattern.charAt(i));
        	if (patterns.containsKey(temp)) {
				if (inputs.containsKey(seperateStr[i]) && patterns.get(temp).
						equals(inputs.get(seperateStr[i]))) {
					continue;
				} else {
					result = false;
					break;
				}
			} else {
				if (!inputs.containsKey(seperateStr[i])) {
					patterns.put(temp, i);
					inputs.put(seperateStr[i], i);
				} else {
					result = false;
					break;
				}
			}
        } 
        return result;
    }
    public static void main(String[] args) {
		LeetCode290 leetCode290 = new LeetCode290();
		String pattern = "abba";
		String str = "dog cat cat dod";
		System.out.println(leetCode290.wordPattern(pattern, str));
	}
}
