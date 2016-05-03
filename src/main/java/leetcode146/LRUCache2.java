package leetcode146;

import java.util.LinkedList;

/**
 * 算法讲解： http://flychao88.iteye.com/blog/1977653
 * 更具体的讲，该算法是淘汰最久没有使用的元素
 * @author liyuncong
 *
 */
public class LRUCache2 {
	private LinkedList<Pair> cache;
	private int capacity;
    public LRUCache2(int capacity) {
        cache = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	int size = cache.size();
        for(int i = 0; i < size; i++) {
        	Pair pair = cache.get(i);
        	if (pair.getKey() == key) {
        		cache.remove(i);
        		cache.addFirst(pair);
				return pair.getValue();
			}
        }
        return -1;
    }
    
    public void set(int key, int value) {
        for (Pair pair : cache) {
			if (pair.getKey() == key) {
				pair.setValue(value);
				return;
			}
		}
        Pair newElement = new Pair(key, value);
        if (cache.size() == capacity) {
			cache.removeLast();
		}
        cache.addFirst(newElement);
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
