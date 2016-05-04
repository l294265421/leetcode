package leetcode146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 算法讲解： http://flychao88.iteye.com/blog/1977653
 * 更具体的讲，该算法是淘汰最久没有使用的元素
 * @author liyuncong
 */
public class LRUCache {
	private LinkedList<Pair> cache;
	// 存的内容与cache一致，用于辅助cache，提供速度，实际上就是用空间换时间
	private Map<Integer, Pair> helper;
	private int capacity;
    public LRUCache(int capacity) {
        cache = new LinkedList<>();
        helper = new HashMap<Integer, LRUCache.Pair>();
        this.capacity = capacity;
    }
    
    /**
     * 如果存在，找到key对应的值，并把这个键值对放到队列的开头；
     * HashMap加链表可以在O(1)内完成(LinkedList删除一个元素的时间复杂度实际上是O(n))
     * @param key
     * @return
     */
    public int get(int key) {
        Pair pair = helper.get(key);
        if (pair != null) {
        	cache.remove(pair);
    		cache.addFirst(pair);
    		return pair.getValue();
		}
        
        return -1;
    }
    
    /**
     * 当缓存中已经存在该key，就修改对应的值，如果没有，就插入；
     * 插入键值对，当缓存满的时候，需要先删除缓存中最久没有使用的元素，然后再插入；
     * HashMap加链表可以在O(1)内完成
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        Pair oldElement = helper.get(key);
        if (oldElement != null) {
        	oldElement.setValue(value);
			return;
		}
        Pair newElement = new Pair(key, value);
        if (cache.size() == capacity) {
			Pair lastElement = cache.removeLast();
			helper.remove(lastElement.getKey());
		}
        cache.addFirst(newElement);
        helper.put(key, newElement);
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
}
