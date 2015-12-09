package leetcode139;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liyuncong
 *
 */
public class LeetCode1393 {
	public boolean wordBreak(String s, Set<String> wordDict) {
	    int[] mem = new int[s.length()+1];
	    mem[0] = 1;
	    int max = 0;
	    for (String word: wordDict) 
	        max = Math.max(max,word.length());
	    // mem[i]等于1，表示s的前i个字符能由词典中的词拼接而成；
	    // 这里要解决的问题是：对于前i个字符的任何拆分都尝试过了吗？
	    // 答案是肯定的。
	    // 这里的过程和递归是一样的：对剩下的每一段，都做从最短长度到
	    // 最大长度的切分，如果某一种切分已经失败了，就不再继续下去。
	    // 在达到i之前，前i个的任何一种切分能成功，mem[i]就会被设置
	    // 为1；
	    // 感觉神奇的是，递归和这所谓的动态规划的思路是一样的，效率居然
	    // 有如此之大的区别。
	    for (int i = 0; i < s.length(); i++) 
	        if (mem[i] == 1) 
	            for (int j = i; j < mem.length && j - i <= max; j++) 
	                if (wordDict.contains(s.substring(i,j))) 
	                    mem[j] = 1;
	    return mem[s.length()] == 1;
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
		LeetCode1393 leetCode139 = new LeetCode1393();
		Set<String> wordDict = new HashSet<>();
		leetCode139.generateWordDict(wordDict, "test.txt");
		String temp = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		System.out.println(leetCode139.wordBreak(temp, wordDict));
	}

}
