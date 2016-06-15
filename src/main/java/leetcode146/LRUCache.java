package leetcode146;

import java.util.HashMap;
import java.util.Map;

/**
 * 算法讲解： http://flychao88.iteye.com/blog/1977653 更具体的讲，该算法是淘汰最久没有使用的元素
 * 
 * @author liyuncong
 */
public class LRUCache {
	private MyList cache;
	// 存的内容与cache一致，用于辅助cache，提高速度，实际上就是用空间换时间
	private Map<Integer, Node> helper;
	private int capacity;

	public LRUCache(int capacity) {
		cache = new MyList();
		helper = new HashMap<Integer, LRUCache.Node>();
		this.capacity = capacity;
	}

	/**
	 * 如果存在，找到key对应的值，并把这个键值对放到栈顶；
	 * HashMap加链表可以在O(1)内完成；
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		Node node = helper.get(key);
		if (node != null) {
			moveNodeToTop(node);
			return node.getItem().getValue();
		}

		return -1;
	}

	/**
	 * 当缓存中已经存在该key，就修改对应的值, 并把对应元素移到栈顶，如果没有，就插入； 
	 * 插入键值对，当缓存满的时候，需要先删除缓存中最久没有使用的元素，然后再插入；
	 * HashMap加链表可以在O(1)内完成
	 * 
	 * @param key
	 * @param value
	 */
	public void set(int key, int value) {
		Node oldNode = helper.get(key);
		if (oldNode != null) {
			oldNode.item.setValue(value);
			moveNodeToTop(oldNode);
			return;
		}
		
		Pair newElement = new Pair(key, value);
		Node newNode = new Node(null, newElement, null);
		if (cache.size == capacity) {
			removeLast();
		}
		addFirst(newNode);
	}
	
	private void moveNodeToTop(Node node) {
		cache.remove(node);
		cache.addFirst(node);
	}
	
	private void removeLast() {
		Pair lastElement = cache.removeLast();
		helper.remove(lastElement.getKey());
	}
	
	private void addFirst(Node node) {
		cache.addFirst(node);
		helper.put(node.getItem().getKey(), node);
	}
	
	@Override
	public String toString() {
		return "LRUCache [cache=" + cache + ", helper=" + helper
				+ ", capacity=" + capacity + "]";
	}

	private static class Pair {
		private int key;
		private int value;

		public Pair(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + key;
			result = prime * result + value;
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
			Pair other = (Pair) obj;
			if (key != other.key)
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}
	}

	/**
	 * 专门用于高效实现LRU的双向链表
	 * 
	 * @author liyuncong
	 * 
	 */
	private static class MyList {
		private int size;
		private Node first;
		private Node last;

		public void addFirst(Node node) {
			if (node == null) {
				return;
			}
			
			Node f = first;
			node.setNext(f);
			first = node;

			if (f == null) {
				last = node;
			} else {
				f.setPrevious(node);
			}
			
			size++;
		}

		public void remove(Node node) {
			if (node == null) {
				return;
			}
			
			Node next = node.next;
			Node prev = node.previous;
			
	        if (prev == null) {
	            first = next;
	        } else {
	            prev.next = next;
	            node.previous = null;
	        }

	        if (next == null) {
	            last = prev;
	        } else {
	            next.previous = prev;
	            node.next = null;
	        }			
	        
	        size--;
		}

		public Pair removeLast() {
			Pair item = last.item;
			
			if (last == null) {
				return null;
			}
			
			Node prev = last.previous;
			last.item = null;
			last.previous = null;
			last = prev;
			if (prev == null) {
				first = null;
			} else {
				prev.next = null;
			}
			
			size--;
			
			return item;
		}
		
		@Override
		public String toString() {
			String result = "";
			Node cursor = first;
			 while (cursor != null) {
				result += cursor.toString();
				cursor = cursor.next;
			}
			return result;
		}
		
	}

	private static class Node {
		private Node previous;
		private Pair item;
		private Node next;

		public Node(Node previous, Pair item, Node next) {
			super();
			this.previous = previous;
			this.item = item;
			this.next = next;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Pair getItem() {
			return item;
		}

		public void setItem(Pair item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [item=" + item + "]";
		}
	}
	
	
	public static void main(String[] args) {
		// 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
		// [-1,3]
		LRUCache lruCache = new LRUCache(2);
		lruCache.set(2, 1);
		lruCache.set(1, 1);
		lruCache.set(2, 3);
		lruCache.set(4, 1);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));
	}
}
