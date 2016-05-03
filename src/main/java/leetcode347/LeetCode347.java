package leetcode347;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 1.统计每个数出现的次数 2.以次数为键建大根堆 3.类似于堆排序，但是只获取堆中出现次数最多的前k个元素
 * 
 * @author liyuncong
 * 
 */
public class LeetCode347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		// 统计每个元素出现的次数
		Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			Integer key = new Integer(nums[i]);
			if (numCount.containsKey(key)) {
				numCount.put(key, numCount.get(key) + 1);
			} else {
				numCount.put(key, 1);
			}
		}
		
		// 构建Pair数组
		Pair[] a = new Pair[numCount.size()];
		int i = 0;
		for (Entry<Integer, Integer> entry : numCount.entrySet()) {
			Pair temp = new Pair(entry.getKey(), entry.getValue());
			a[i] = temp;
			i++;
		}
		
		// 建堆
		int heapLength = a.length;
		buildHeap(a, heapLength);
		
		List<Integer> result = new LinkedList<>();
		// 从堆中获取出现次数最多的前k个元素
		for(int j = 0; j < k; j++) {
			Pair temp = a[0];
			result.add(temp.getNum());
			
			a[0] = a[heapLength - 1];
			heapLength--;
			heapify(a, 0, heapLength);
			
		}
		return result;
	}

	/**
	 * 保存在堆中，携带有数字及其出现的次数。
	 * @author liyuncong
	 *
	 */
	private static class Pair implements Comparable<Pair> {
		private int num;
		private int count;

		public Pair(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		
		@Override
		public String toString() {
			return "Pair [num=" + num + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Pair o) {
			if (o == null) {
				throw new IllegalArgumentException("用于比较的Pair对象不能为null");
			}
			int oCount = o.getCount();
			if (this.count < oCount) {
				return -1;
			} else if (this.count > oCount) {
				return 1;
			}
			return 0;
		}

	}

	public int left(int i) {
		return (i + 1) * 2 - 1;
	}

	public int right(int i) {
		return (i + 1) * 2;
	}

	public int parent(int i) {
		// i为根结点
		if (i == 0) {
			return -1;
		}
		return (i - 1) / 2;
	}

	/**
	 * 保持堆的性质
	 * 
	 * @param a
	 *            保存堆的数组
	 * @param i
	 *            堆中需要下降的元素
	 * @param heapLength
	 *            堆元素个数
	 */
	public void heapify(Pair[] a, int i, int heapLength) {
		int l = left(i);
		int r = right(i);
		int largest = -1;

		// 寻找 i l r三个位置上最大元素所在的位置
		if (l < heapLength && a[i].compareTo(a[l]) < 0) {
			largest = l;
		} else {
			largest = i;
		}

		if (r < heapLength && a[largest].compareTo(a[r]) < 0) {
			largest = r;
		}

		if (i != largest) {
			Pair temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			heapify(a, largest, heapLength);
		}
	}

	/**
	 * 建堆
	 * 
	 * @param a
	 *            数组
	 * @param heapLength
	 *            数组中堆元素的个数
	 */
	public void buildHeap(Pair[] a, int heapLength) {
		int firstPositionHasChild = parent(heapLength - 1);
		for (int i = firstPositionHasChild; i >= 0; i--) {
			heapify(a, i, heapLength);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,2,2,3};
		int k = 2;
		LeetCode347 leetCode347 = new LeetCode347();
		List<Integer> result = leetCode347.topKFrequent(nums, k);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}
}
