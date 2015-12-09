package leetcode139;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1392 {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	int maxLenOfWord = getMaxLen(wordDict);
        return wordBreak(s, wordDict, maxLenOfWord);
    }
    
    /**
     * 获得字典中最长单词的长度
     * @param wordDict
     * @return
     */
    public int getMaxLen(Set<String> wordDict) {
    	int maxLen = 0;
		for (String string : wordDict) {
			int len = string.length();
			if (len > maxLen) {
				maxLen = len;
			}
		}
		return maxLen;
	}
    
    /**
     * 把词典中单词的最大长度也考虑进来
     * @param s
     * @param wordDict
     * @param maxLenOfWord
     * @return
     */
    public boolean wordBreak(String s, Set<String> wordDict, int maxLenOfWord) {
    	int len = s.length();
    	if (len <= maxLenOfWord && wordDict.contains(s)) {
			return true;
		}
        boolean result = false;
        // i既代表取出部分的长度，也代表取出部分的终点索引+1；
        // 取出的部分不可能是s;
        // 优先选择长的，这样可以减小递归深度;
        // 查询部分的长度最长只能与maxLenOfWord相等;
        int maxIndex = Math.min(maxLenOfWord, len - 1);
        for(int i = 1; i <= maxIndex; i++) {
        	String part = s.substring(0, i);
        	boolean thisResult = wordDict.contains(part);
        	if (thisResult) {
				result = result || wordBreak(s.substring(i), wordDict, maxLenOfWord);
			}
        	// 只需要找到一个分解序列就行
        	if (result == true) {
				break;
			}
        }
        return result;
    }
    
    /**
     * 生成词典的字符串在文件的第二行
     * @param wordDict 填充的词典
     * @param fileName 保存用于生成词典的字符串的文件
     */
    public void generateWordDict(Set<String> wordDict, String fileName) {
    	Path path = Paths.get(fileName);
    	Charset cs = Charset.forName("utf-8");
    	List<String> lines = null;
		try {
			lines = Files.readAllLines(path, cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] wordWithQuotationMark = lines.get(1).substring(1, lines.get(1).length() - 1).split(",");
		for (String string : wordWithQuotationMark) {
			int len = string.length();
			wordDict.add(string.substring(1, len - 1));
		}
	}

	public static void main(String[] args) {
		LeetCode1392 leetCode139 = new LeetCode1392();
		Set<String> wordDict = new HashSet<>();
		leetCode139.generateWordDict(wordDict, "test.txt");
		String temp = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(leetCode139.wordBreak(temp, wordDict));
	}

}
