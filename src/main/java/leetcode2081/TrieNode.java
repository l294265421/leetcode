package leetcode2081;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Character key;
	private Map<Character, TrieNode> children = new HashMap<>();
	
	// 孩子节点包含SENTINEL的节点是单词的词尾字符
	public static final TrieNode SENTINEL; 
	
	static {
		SENTINEL = new TrieNode();
		SENTINEL.setKey('$');
	}
	
	public TrieNode() {
	}

	public Character getKey() {
		return key;
	}

	public void setKey(Character key) {
		this.key = key;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}
	
	public TrieNode getChild(char character) {
		return this.children.get(character);
	}
	
	public void addChild(TrieNode child) {
		this.children.put(child.getKey(), child);
	}
	
	public boolean containChild(TrieNode child) {
		return children.containsValue(child);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrieNode other = (TrieNode) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}
