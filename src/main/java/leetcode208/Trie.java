package leetcode208;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = TrieNode.SENTINEL;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word == null || word.trim().length() == 0) {
			return;
		}
        TrieNode cursor = root;
        int len = word.length();
        for(int i = 0; i < len; i++) {
        	Character temp = word.charAt(i);
        	TrieNode child = cursor.getChild(temp);
        	if (child == null) {
				child = new TrieNode(temp);
				cursor.addChild(child);
			}
        	cursor = child;
        }
        cursor.addChild(TrieNode.SENTINEL);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
			return false;
		}
        TrieNode cursor = root;
        int len = word.length();
        for(int i = 0; i < len; i++) {
        	Character temp = word.charAt(i);
        	TrieNode child = cursor.getChild(temp);
        	if (child == null) {
				return false;
			}
        	cursor = child;
        }
        
        if (!cursor.containChild(TrieNode.SENTINEL)) {
			return false;
		}
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
			return false;
		}
        TrieNode cursor = root;
        int len = prefix.length();
        for(int i = 0; i < len; i++) {
        	Character temp = prefix.charAt(i);
        	TrieNode child = cursor.getChild(temp);
        	if (child == null) {
				return false;
			}
        	cursor = child;
        }
        
        return true;
    }
    
}
