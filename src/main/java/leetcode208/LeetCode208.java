package leetcode208;

public class LeetCode208 {
	public static void main(String[] args) {
		 Trie trie = new Trie();
		 trie.insert("ab");
		 System.out.println(trie.search("a"));
		 System.out.println(trie.startsWith("a"));
	}
}
