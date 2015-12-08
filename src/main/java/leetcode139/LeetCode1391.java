package leetcode139;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1391 {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if (wordDict.contains(s)) {
			return true;
		}
        boolean result = false;
        int len = s.length();
        // i既代表取出部分的长度，也代表取出部分的终点索引+1；
        // 取出的部分不可能是s;
        // 优先选择长的，这样可以减小递归深度
        for(int i = len - 1; i >= 1; i--) {
        	String part = s.substring(0, i);
        	boolean thisResult = wordDict.contains(part);
        	if (thisResult) {
				result = result || wordBreak(s.substring(i), wordDict);
			}
        	// 只需要找到一个分解序列就行
        	if (result == true) {
				break;
			}
        }
        return result;
    }

	public static void main(String[] args) {
		LeetCode1391 leetCode139 = new LeetCode1391();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(leetCode139.wordBreak("leetcode", wordDict));
	}

}
