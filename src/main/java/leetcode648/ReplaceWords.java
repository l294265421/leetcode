package leetcode648;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
In English, we have a concept called root, which can be followed by some other words 
to form another longer word - let's call this word successor. For example, the root an,
 followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace 
all the successor in the sentence with the root forming it. If a successor has many 
roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Note:

    The input will only have lower-case letters.
    1 <= dict words number <= 1000
    1 <= sentence words number <= 1000
    1 <= root length <= 100
    1 <= sentence words length <= 1000

 * @author liyuncong
 *
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        trie.setC('/');
        for (String root : dict) {
			trie.addChild(root);
		}
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
        	String prefix = Trie.searchPrefix(words[i], trie);
        	if (!"".equals(prefix)) {
				result.append(prefix);
			} else {
				result.append(words[i]);
			}
        	if (i != words.length - 1) {
				result.append(" ");
			}
        }
        return result.toString();
    }
    
    private static class Trie {
    	private char c;
    	private Map<Character, Trie> children = new HashMap<>();
    	private boolean isEnd = false;
    	
    	public void addChild(String wordPart) {
			Trie trie = children.get(wordPart.charAt(0));
			if (trie == null) {
				trie = new Trie();
				trie.c =wordPart.charAt(0);
				children.put(wordPart.charAt(0), trie);
			}
			if (wordPart.length() > 1) {
				trie.addChild(wordPart.substring(1));
			} else {
				trie.isEnd = true;
			}
		}
    	
    	public char getC() {
			return c;
		}

		public void setC(char c) {
			this.c = c;
		}

		public Map<Character, Trie> getChildren() {
			return children;
		}

		public void setChildren(Map<Character, Trie> children) {
			this.children = children;
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

		/**
		 * 
		 * @param word
		 * @param trie
		 * @return 没有找到返回空字符串
		 */
		public static String searchPrefix(String word, Trie trie) {
			Trie child = trie;
			for(int i = 0; i < word.length(); i++) {
				child = child.getChildren().get(word.charAt(i));
				if (child == null) {
					return "";
				} else if (child.isEnd) {
					return word.substring(0, i + 1);
				}
			}
			return "";
		}
    }
    
    public static void main(String[] args) {
		ReplaceWords replaceWords = new ReplaceWords();
		String[] words = new String[] {"cat", "bat", "rat"};
		System.out.println(replaceWords.replaceWords(Arrays.asList(words), 
				"the cattle was rattled by the battery"));
	}
}
